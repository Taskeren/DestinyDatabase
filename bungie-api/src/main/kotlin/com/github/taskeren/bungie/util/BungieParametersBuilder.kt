package com.github.taskeren.bungie.util

import io.ktor.http.*

class BungieParametersBuilder(private val delegation: ParametersBuilder) : ParametersBuilder by delegation {

	/**
	 * 用于棒鸡 API 的 ParametersBuilder
	 *
	 * 覆盖原有的 appendAll 逻辑，改为将列表值变成以逗号分隔的字符串
	 */
	override fun appendAll(name: String, values: Iterable<String>) {
		append(name, values.joinToString(separator = ","))
	}

	override fun toString(): String {
		return "BungieParametersBuilder{${super.toString()}}"
	}
}