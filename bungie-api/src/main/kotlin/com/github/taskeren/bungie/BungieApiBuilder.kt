package com.github.taskeren.bungie

import com.github.taskeren.bungie.util.Debugging
import com.github.taskeren.tserial.OffsetDateTimeSerializer
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.plugins.logging.LogLevel.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import java.time.OffsetDateTime

private val defaultJson by lazy {
	Json {
		isLenient = true
		prettyPrint = true
		ignoreUnknownKeys = true
		coerceInputValues = true

		serializersModule = SerializersModule {
			contextual(OffsetDateTime::class, OffsetDateTimeSerializer)
		}
	}
}

@Suppress("MemberVisibilityCanBePrivate")
class BungieApiBuilder(block: BungieApiBuilder.() -> Unit) {

	var apiKey: String? = null
	var accessToken: String? = null

	/**
	 * 用于 API 网络请求的 [HttpClient]，默认使用 [newDefaultHttpClient] 创建
	 */
	var http: HttpClient? = null

	/**
	 * 用于数据序列化/反序列化的 [Json]，默认使用 [defaultJson]
	 */
	var json: Json? = null

	var configureHttpClient: HttpClientConfig<*>.() -> Unit = {}

	init {
		this.apply(block)
	}

	private fun newDefaultHttpClient(json: Json) = HttpClient(OkHttp) {
		// enable http logging if in debug mode
		if(Debugging.debugMode) {
			install(Logging) {
				level = ALL
			}
		}

		install(ContentNegotiation) {
			json(json)
		}

		// user http client customization
		configureHttpClient()
	}

	fun build(): BungieApi {
		require(apiKey != null) { "ApiKey must be set!" }

		// 建立 HttpClient 用于 API 请求
		if(http == null) {
			http = newDefaultHttpClient(json ?: defaultJson)
		}

		return BungieApi(apiKey!!, accessToken, http!!)
	}

}