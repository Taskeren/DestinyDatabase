@file:JvmName("OAuthLoginMain")

package com.github.taskeren.bungie

import com.github.taskeren.bungie.oauth.BungieOAuth
import io.ktor.http.*
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.awt.Desktop
import kotlin.time.Duration.Companion.seconds

fun main(args: Array<String>): Unit = runBlocking {

	println("OAuthLogin for Bungie")

	// setup system proxies
	System.setProperty("java.net.useSystemProxies", "true")

	val apiKey = args.getOrNull(0)
	if(apiKey == null) {
		println("You need to provide apiKey using parameter!")
		return@runBlocking
	}

	val clientId = args.getOrNull(1)
	if(clientId == null) {
		println("You need to provide clientId using parameter!")
		return@runBlocking
	}

	val clientSecret = args.getOrNull(2)
	if(clientSecret == null) {
		println("You need to provide clientSecret using parameter!")
		return@runBlocking
	}

	val shouldRefreshToken = "--refresh-token" in args

	println("=== Settings ===")
	println("- ApiKey:    $apiKey")
	println("- ClientId:  $clientId")
	println("- ClientSec: $clientSecret")

	val api = BungieApi(apiKey)

	val cachedToken = AccessTokenCache.restore()

	if(cachedToken == null) {
		println("No cached token found or error when getting")

		val oauthUrl = api.authorize.getAuthorizeUrl(clientId)

		val jobGetToken = async {
			val loginCode = BungieOAuth.waitForLoginCodeSSL(port = 8080)
			println("Login code: $loginCode")
			// get token
			println("Fetching token")
			api.authorize.getToken(loginCode, clientId, clientSecret)
		}

		runCatching {
			println("Opening browser to login")
			println("Ignore and continue if the browser warns you the untrusted certification!")
			Desktop.getDesktop().browse(oauthUrl.toURI())
		}.onFailure {
			println("Failed to start the browser, you need to open the url manually:")
			println(oauthUrl.toURI())
		}

		// wait for getting token
		val token = jobGetToken.await()
		println(token)

		api.setToken(token)

		if(shouldRefreshToken) {
			println("Wait 3 seconds, and try to refresh token")
			delay(3.seconds)

			val tokenRefreshed = api.authorize.refreshToken(token.refreshToken, clientId, clientSecret)
			println(tokenRefreshed)

			api.setToken(tokenRefreshed)
		}
	} else {
		println("Using cached token: $cachedToken")
		api.setToken(cachedToken)
	}

	println("Tokenized")

//	api.destiny2.getProfile(
//		MembershipType.TigerSteam,
//		4611686018500727480,
//		listOf(DestinyComponentType.Profiles)
//	).let(::println)
}