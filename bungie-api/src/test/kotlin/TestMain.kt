import com.github.taskeren.bungie.BungieApi
import com.github.taskeren.bungie.oauth.BungieOAuth
import com.sun.jdi.InvocationException
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.awt.Desktop
import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.hasAnnotation

val logger: Logger = LoggerFactory.getLogger("ApiTestMain")

suspend fun main(args: Array<String>) = runBlocking {

	logger.info("Initializing api testing sequences, getting required values")

	val apiKey: String
	val clientId: Long
	val clientSecret: String

	// get required parameters
	if(args.size == 3) {
		apiKey = args[0]
		clientId = args[1].toLong()
		clientSecret = args[2]
	} else {
		apiKey = System.getenv("TEST_API_KEY")!!
		clientId = System.getenv("TEST_CLIENT_ID")!!.toLong()
		clientSecret = System.getenv("TEST_CLIENT_SECRET")!!
	}

	// prepare functions to be tested
	val instance = TestBungieApi()
	val functions: List<TestSection> =
		// if there is any function annotated with NovaOnlyThis, then it will be the only one that executes
		// otherwise, run every test functions
		if(TestBungieApi::class.declaredMemberFunctions.none { it.hasAnnotation<NovaOnlyThis>() }) {
			TestBungieApi::class.declaredMemberFunctions.filter {
				it.hasAnnotation<Test>() || it.hasAnnotation<TestByNova>()
			}.filter { it.parameters.size == 1 }.map {
				TestSection(it.name) { it.call(instance) }
			}
		} else {
			val f = TestBungieApi::class.declaredMemberFunctions.first { it.hasAnnotation<NovaOnlyThis>() }
			listOf(TestSection(f.name) { f.call(instance) })
		}

	logger.info("Found ${functions.size} functions to be tested")

	// oauth sequence
	val api = BungieApi {
		this.apiKey = apiKey
		this.configureHttpClient = {
			engine {
				proxy = ProxyBuilder.http("http://127.0.0.1:7890")
			}
		}
	}

	val at = run {
		logger.info("Initializing OAuth sequence")

		val url = api.authorize.getAuthorizeUrl(clientId.toString())
		val atJob = async {
			val loginCode = BungieOAuth.waitForLoginCodeSSL(port = 8080)
			logger.info("Accepted Login Code: $loginCode")
			api.authorize.getToken(loginCode, clientId.toString(), clientSecret)
		}

		runCatching {
			println("Opening browser to login")
			println("Ignore and continue if the browser warns you the untrusted certification!")
			Desktop.getDesktop().browse(url.toURI())
		}.onFailure {
			println("Failed to start the browser, you need to open the url manually:")
			println(url.toURI())
		}

		atJob.await()
	}

	logger.info("Accepted Access Token: $at")

	// before test
	api.setToken(at)
	instance.bungieApi = api

	// test
	logger.info("Starting tests!")

	var passCount = 0
	functions.forEachIndexed { index, it ->
		val result = it.test()
		if(result.isSuccess) {
			logger.info("[${index + 1}/${functions.size}] ${it.functionName} Pass")
			passCount++
		}
		if(result.isFailure) {
			logger.warn(
				"[${index + 1}/${functions.size}] ${it.functionName} Failed",
				result.exceptionOrNull().unwrapInvocation()
			)
		}
	}

	logger.info("All tests has finished, $passCount passed and ${functions.size - passCount} failed.")
}

@Retention(RUNTIME)
annotation class TestByNova

@Retention(RUNTIME)
annotation class NovaOnlyThis

data class TestSection(val functionName: String, val body: () -> Any?) {
	fun test() = runCatching(body)
}

fun Throwable?.unwrapInvocation() = if(this is InvocationException) this.cause else this