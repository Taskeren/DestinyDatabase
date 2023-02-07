package com.github.taskeren.bungie.oauth

import io.ktor.http.*
import io.ktor.network.tls.certificates.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.slf4j.LoggerFactory
import java.io.File
import java.security.KeyStore
import java.util.Properties
import kotlin.coroutines.suspendCoroutine

private val sslConfigFile = File("bungie_oauth.properties")

private val sslConfig = Properties().apply {
	if(sslConfigFile.exists()) {
		load(sslConfigFile.reader())
	} else {
		// init
		put("bungie.oauth.ssl.keystore_path", "keystore.jks")
		put("bungie.oauth.ssl.keystore_password", "bungie_is_dumb")
		put("bungie.oauth.ssl.certificate_alias", "default_certificate")
		put("bungie.oauth.ssl.certificate_password", "bungie_is_ass")
		// store
		store(sslConfigFile.writer(), "initializing")
	}
}

private fun getSettingsValue(key: String, default: String) =
	System.getProperty(key) ?: sslConfig.getProperty(key) ?: default

private val keyStorePath = getSettingsValue("bungie.oauth.ssl.keystore_path", "keystore.jks")
private val keyStorePassword = getSettingsValue("bungie.oauth.ssl.keystore_password", "bungie_is_dumb")
private val certificateAlias = getSettingsValue("bungie.oauth.ssl.certificate_alias", "default_certificate")
private val certificatePassword = getSettingsValue("bungie.oauth.ssl.certificate_password", "bungie_is_ass")

private val keyStoreFile = File(keyStorePath)

private var server: NettyApplicationEngine? = null

object BungieOAuth {

	private fun generateDefaultKeyStore() {
		val keyStore = buildKeyStore {
			certificate(certificateAlias) {
				password = certificatePassword
				domains = listOf("127.0.0.1", "0.0.0.0", "localhost")
			}
		}
		keyStore.saveToFile(keyStoreFile, keyStorePassword)
	}

	/**
	 * Start a server to receive the login code.
	 *
	 * You should set your Redirect URL of the Application to this computer, including "127.0.0.1", "localhost", or public address.
	 *
	 * The server is running under normal HTTP protocol, which is not allowed by Bungie.
	 * You need using Nginx or something to secure the link.
	 */
	suspend fun waitForLoginCode(state: Int = 1, port: Int = 8080, host: String = "0.0.0.0") =
		waitForLoginCode(state, port, null, host)

	/**
	 * Start a server to receive the login code.
	 *
	 * You should set your Redirect URL of the Application to this computer, including "127.0.0.1", "localhost", or public address.
	 */
	suspend fun waitForLoginCodeSSL(state: Int = 1, port: Int = 8443, host: String = "0.0.0.0") =
		waitForLoginCode(state, null, port, host)

	private suspend fun waitForLoginCode(state: Int = 1, port: Int? = 8080, portSSL: Int? = 8443, host: String = "0.0.0.0") =
		suspendCoroutine { continuation ->
			require(server == null) { "Receiving server has been set!" }

			require(port != null || portSSL != null) { "Both port and portSSL are null!" }

			val environment = applicationEngineEnvironment {
				log = LoggerFactory.getLogger("BungieOAuthLocalServer")

				// normal connector
				if(port != null) {
					connector {
						this.host = host
						this.port = port
					}
				}

				// ssl connector
				if(portSSL != null) {
					if(!keyStoreFile.exists()) {
						// generate a keystore
						generateDefaultKeyStore()
					}

					sslConnector(
						keyStore = KeyStore.getInstance(keyStoreFile, keyStorePassword.toCharArray()),
						keyAlias = certificateAlias,
						keyStorePassword = { keyStorePassword.toCharArray() },
						privateKeyPassword = { certificatePassword.toCharArray() },
					) {
						this.host = host
						this.port = portSSL
						this.keyStorePath = keyStoreFile
					}
				}

				module {
					routing {
						get("/") {
							// get code from request
							val loginCode = call.parameters["code"]
								?: call.respondText("Invalid code!", status = HttpStatusCode.BadRequest)
							val stateCode = call.parameters["state"]
								?: call.respondText("Invalid state!", status = HttpStatusCode.BadRequest)

							if(state.toString() == stateCode) {
								// respond result
								call.respondText(RESPONSE_HTML, ContentType.Text.Html, HttpStatusCode.Accepted)
//								call.respondText("You can close the browser now. // <x-bungie-oauth>", status = HttpStatusCode.Accepted)

								// feed with the result
								continuation.resumeWith(Result.success(loginCode.toString()))

								// clean up
								server?.stop() ?: error("unreachable: server should now exist and not be closed!")
								server = null
							} else {
								call.respondText("State not matched!", status = HttpStatusCode.BadRequest)
							}
						}
					}
				}
			}

			server = embeddedServer(Netty, environment).apply(ApplicationEngine::start)
		}
}

private const val RESPONSE_HTML = """
<html>
	<head>
		<title>X-Bungie-OAuth</title>
	</head>
	<body>
		<p>You can close the browser now. // x-bungie-oauth </p>
	</body>
	<script>
		setTimeout(() => { window.close() }, 3000)
	</script>
</html>
"""