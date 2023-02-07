@file:JvmName("OAuthLoginMain")

package com.github.taskeren.bungie.util

import com.github.taskeren.bungie.BungieApi
import com.github.taskeren.bungie.oauth.BungieOAuth
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.awt.Desktop

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

	println("=== Settings ===")
	println("- ApiKey:    $apiKey")
	println("- ClientId:  $clientId")
	println("- ClientSec: $clientSecret")

	val api = BungieApi(apiKey)
	val oauthUrl = api.authorize.getAuthorizeUrl(clientId)

	launch {
		val loginCode = BungieOAuth.waitForLoginCodeSSL(port = 8080)
		println("Login code: $loginCode")
		// get token
		println("Fetching token")
		val token = api.authorize.getToken(loginCode, clientId, clientSecret)
		println(token)
	}

	launch {
		runCatching {
			println("Opening browser to login")
			Desktop.getDesktop().browse(oauthUrl.toUri())
		}.onFailure {
			println("Failed to start the browser, you need to open the url manually:")
			println(oauthUrl.toUri().toString())
		}
	}

}