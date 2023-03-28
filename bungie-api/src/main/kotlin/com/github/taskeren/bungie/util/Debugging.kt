package com.github.taskeren.bungie.util

object Debugging {

	private fun getSystemValue(key: String): String? {
		return System.getenv(key) ?: System.getProperty(key)
	}

	private val String?.bool get() = this == "true"

	val trustedMode get() = getSystemValue("bungie.api.trusted").bool || getSystemValue("bungie.api.show-token").bool

	val debugMode get() = getSystemValue("bungie.api.debug").bool || getSystemValue("bungie.api.dev").bool

}