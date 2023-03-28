package com.github.taskeren.bungie

import com.github.taskeren.bungie.compat.EntityType
import com.github.taskeren.bungie.entity.MembershipType
import com.github.taskeren.bungie.entity.destiny.DestinyComponentType
import com.github.taskeren.bungie.entity.destiny.config.DestinyManifest
import com.github.taskeren.bungie.entity.destiny.definitions.DestinyDefinition
import com.github.taskeren.bungie.entity.destiny.responses.DestinyCharacterResponse
import com.github.taskeren.bungie.entity.destiny.responses.DestinyItemResponse
import com.github.taskeren.bungie.entity.destiny.responses.DestinyProfileResponse
import com.github.taskeren.bungie.entity.user.UserInfoCard
import com.github.taskeren.bungie.util.BungieParametersBuilder
import com.github.taskeren.bungie.util.Debugging
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.util.reflect.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.*
import okhttp3.*
import org.slf4j.LoggerFactory

private val logger = LoggerFactory.getLogger("BungieApi")

const val HEADER_API_KEY = "x-api-key"

/**
 * 构建一个棒鸡API
 */
fun BungieApi(xApiKey: String, accessToken: String? = null) = BungieApiBuilder {
	this.apiKey = xApiKey
	this.accessToken = accessToken
}.build()

fun BungieApi(block: BungieApiBuilder.() -> Unit) = BungieApiBuilder(block).build()

class BungieApi internal constructor(
	private val xApiKey: String,
	private var accessToken: String?,
	private val http: HttpClient,
) {

	private fun buildApiUrl(endpoint: String, param: ParametersBuilder.() -> Unit = {}): Url {
		return URLBuilder("https://www.bungie.net/Platform").apply {
			// add endpoint to url
			appendPathSegments(endpoint)
			// process query parameters
			parameters.let(::BungieParametersBuilder).param()
		}.build()
	}

	private fun HttpRequestBuilder.processAuth(requireAccessToken: Boolean = false, errorTracingContext: String) {
		this.header(HEADER_API_KEY, xApiKey)
		if(requireAccessToken) {
			require(accessToken != null) { "AccessToken must be provided when calling '$errorTracingContext'" }
			this.header(HttpHeaders.Authorization, "Bearer $accessToken")
		}
	}

	private suspend fun get(
		url: String,
		parameters: ParametersBuilder.() -> Unit = {},
		withAccessToken: Boolean = false,
	): HttpResponse {
		return http.get(buildApiUrl(url, parameters)) {
			// set apikey and access token
			processAuth(withAccessToken, "ApiEndpoint: $url")
		}
	}

	private suspend fun post(
		url: String,
		parameters: ParametersBuilder.() -> Unit = {},
		body: Any? = null,
		contentType: ContentType? = ContentType.Application.Json,
		withAccessToken: Boolean = false,
	): HttpResponse {
		return http.post(buildApiUrl(url, parameters)) {
			// set apikey and access token
			processAuth(withAccessToken, "ApiEndpoint: $url")

			// set body
			setBody(body)
			contentType?.let { contentType(it) }
		}
	}

	private fun buildResourceUrl(relativePath: String): Url {
		return URLBuilder("https://www.bungie.net").apply {
			appendPathSegments(relativePath)
		}.build()
	}

	private suspend fun getResource(relativePath: String): HttpResponse {
		return http.get(buildResourceUrl(relativePath)) {
			processAuth(false, "Resource: $relativePath")
		}
	}

	private fun setToken(accessToken: String) {
		logger.info("AccessToken updated!")
		if(Debugging.trustedMode) {
			logger.info("New AT: $accessToken")
		}
		this.accessToken = accessToken
	}

	/**
	 * 设置 [BungieApi.accessToken]
	 */
	fun setToken(accessToken: AccessToken) = setToken(accessToken.accessToken)

	val authorize by lazy { Authorize() }

	val destiny2 = Destiny2()
	val helpers = Helpers()

	inner class Authorize internal constructor() {

		/**
		 * 获取授权地址
		 * @param clientId 应用的 client_id（在棒鸡 Application 中查看）
		 */
		fun getAuthorizeUrl(clientId: String, state: String = "1"): Url {
			return URLBuilder("https://www.bungie.net/en/oauth/authorize").apply {
				parameters.append("state", state)
				parameters.append("client_id", clientId)
				parameters.append("response_type", "code")
			}.build()
		}

		suspend fun getToken(code: String, clientId: String, clientSecret: String): AccessToken = post(
			"/App/OAuth/Token/",
			body = FormDataContent(
				parametersOf(
					"grant_type" to "authorization_code",
					"code" to code,
					"client_id" to clientId,
					"client_secret" to clientSecret
				)
			),
			contentType = ContentType.Application.FormUrlEncoded
		).body()

		suspend fun refreshToken(refreshToken: String, clientId: String, clientSecret: String): AccessToken = post(
			"/App/OAuth/Token/",
			body = FormDataContent(
				parametersOf(
					"grant_type" to "refresh_token",
					"refresh_token" to refreshToken,
					"client_id" to clientId,
					"client_secret" to clientSecret
				)
			),
			contentType = ContentType.Application.FormUrlEncoded
		).body()
	}

	private fun parametersOf(
		vararg pairs: Pair<String, String>,
	): Parameters = parametersOf(pairs.associate { (key, value) -> key to listOf(value) })

	inner class Destiny2 internal constructor() {

		suspend fun getDestinyManifest(): BungieApiResponse<DestinyManifest> = get("/Destiny2/Manifest/").body()

		suspend fun getDestinyManifest(
			entityType: EntityType,
			hashIdentifier: UInt,
		): BungieApiResponse<DestinyDefinition> = get("/Destiny2/Manifest/${entityType.name}/$hashIdentifier/").body()

		suspend fun searchDestinyPlayer(
			membershipType: MembershipType,
			displayName: String,
		): BungieApiResponse<List<UserInfoCard>> =
			get("/Destiny2/SearchDestinyPlayer/${membershipType.value}/$displayName/").body()

		private fun lambdaAppendComponents(components: List<DestinyComponentType>): ParametersBuilder.() -> Unit = {
			appendAll("components", components.map { it.value.toString() })
		}

		suspend fun getProfile(
			membershipType: MembershipType, destinyMembershipId: Long, components: List<DestinyComponentType>,
		): BungieApiResponse<DestinyProfileResponse> = get(
			"/Destiny2/${membershipType.value}/Profile/$destinyMembershipId/", lambdaAppendComponents(components), true
		).body()

		suspend fun getCharacter(
			membershipType: MembershipType,
			destinyMembershipId: Long,
			characterId: Long,
			components: List<DestinyComponentType>,
		): BungieApiResponse<DestinyCharacterResponse> = get(
			"/Destiny2/${membershipType.value}/Profile/$destinyMembershipId/Character/$characterId/",
			lambdaAppendComponents(components)
		).body()

		suspend fun getItem(
			membershipType: MembershipType,
			destinyMembershipId: Long,
			itemInstanceId: Long,
			components: List<DestinyComponentType>,
		): BungieApiResponse<DestinyItemResponse> = get(
			"/Destiny2/${membershipType.value}/Profile/$destinyMembershipId/Item/$itemInstanceId/",
			lambdaAppendComponents(components)
		).body()

		// TODO: Add other API entries
	}

	inner class Helpers internal constructor() {

		suspend fun getBungieResource(path: String) = getResource(path)

	}

	companion object {

		/**
		 * 获取 Light.gg 的网页地址
		 */
		val HashId.lggUrl get() = "https://www.light.gg/db/items/$hash/"

		/**
		 * (property) bungie.api.show-token
		 * 是否在 [BungieApi.toString] 时显示 [BungieApi.accessToken]
		 */
		private val shouldShowToken get() = Debugging.trustedMode

	}

	override fun toString(): String =
		if(shouldShowToken) "BungieApi(apiKey=$xApiKey, token=$accessToken)" else "BungieApi(apiKey=$xApiKey)"

}

@JvmInline
value class HashId(val hash: UInt) {

	companion object {
		fun UInt.hashId() = HashId(this)
		fun String.hashId() = HashId(this.toUInt())
	}
}

@Serializable
data class BungieApiResponse<T>(
	@SerialName("Response")
	val response: T? = null,
	@SerialName("ErrorCode")
	val errorCode: Int? = null,
	@SerialName("ThrottleSeconds")
	val throttleSeconds: Int? = null,
	@SerialName("Message")
	val message: String? = null,
	@SerialName("MessageData")
	val messageData: Map<String, String?>? = null,
) {
	val data: T get() = response ?: error("Cannot get response data, $message")
}

// Helpers

fun String.toBungieResourceUrl() = "https://www.bungie.net$this"