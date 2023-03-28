package com.github.taskeren.bungie

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.io.path.Path
import kotlin.io.path.readText
import kotlin.io.path.writeText

object AccessTokenCache {

	private val CachePath = Path("build/oauth.json")

	fun AccessToken.store() {
		CachePath.writeText(Json.encodeToString(this))
	}

	fun restore(): AccessToken? {
		return runCatching {
			Json.decodeFromString<AccessToken>(CachePath.readText())
		}.getOrNull()
	}

}