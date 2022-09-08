package com.github.taskeren.bungie

import com.github.taskeren.bungie.compat.EntityType
import com.github.taskeren.bungie.entity.MembershipType
import com.github.taskeren.bungie.entity.destiny.DestinyComponentType
import com.github.taskeren.bungie.entity.destiny.config.DestinyManifest
import com.github.taskeren.bungie.entity.destiny.definitions.DestinyDefinition
import com.github.taskeren.bungie.entity.destiny.responses.*
import com.github.taskeren.bungie.entity.user.UserInfoCard
import com.github.taskeren.tserial.OffsetDateTimeSerializer
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.*
import kotlinx.serialization.modules.SerializersModule
import okhttp3.*
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.internal.EMPTY_REQUEST
import org.apache.logging.log4j.LogManager
import java.net.URLEncoder
import java.time.OffsetDateTime

private val logger = LogManager.getLogger("BungieApi")

class BungieApi(
	val xApiKey: String,
) {

	private val cli = OkHttpClient()

	private fun get(url: String): Response {
		val req = Request.Builder().get().url("https://www.bungie.net/Platform${URLEncoder.encode(url, "utf-8")}")
			.header("X-API-Key", xApiKey).build()
		return cli.newCall(req).execute()
	}

	private fun getWithQuery(url: String, query: Map<String, Any>): Response {
		val httpUrl =
			HttpUrl.Builder().scheme("https").host("www.bungie.net").addPathSegments("/Platform/").addPathSegment(url)
				.apply {
					query.forEach { (queryName, queryEntity) ->
						if(queryEntity is Iterable<*>) {
							val queryValue = queryEntity.filterNotNull().joinToString(separator = ",")
							this.addQueryParameter(queryName, queryValue)
						} else {
							throw BungieException("Unexpected type of queries: ${queryEntity.javaClass.canonicalName}")
						}
					}
				}.build()

		val req = Request.Builder().get().url(httpUrl).header("X-API-Key", xApiKey).build()
		return cli.newCall(req).execute()
	}

	private fun post(url: String, query: Map<String, Any> = mapOf(), body: RequestBody = EMPTY_REQUEST): Response {
		val httpUrl =
			HttpUrl.Builder().scheme("https").host("www.bungie.net").addPathSegments("/Platform/").addPathSegment(url)
				.apply {
					query.forEach { (queryName, queryEntity) ->
						if(queryEntity is Iterable<*>) {
							val queryValue = queryEntity.filterNotNull().joinToString(separator = ",")
							this.addQueryParameter(queryName, queryValue)
						}
					}
				}.build()
		val request = Request.Builder().post(body).url(httpUrl).header("X-API-Key", xApiKey).build()
		return cli.newCall(request).execute()
	}

	private fun getResource(url: String): Response {
		val req = Request.Builder().get().url("https://www.bungie.net$url").header("X-API-Key", xApiKey).build()
		return cli.newCall(req).execute()
	}

	val authorize by lazy { Authorize() }
	val destiny2 = Destiny2()
	val helpers = Helpers()

	inner class Authorize internal constructor() {

		/**
		 * 获取授权地址
		 * @param clientId 应用的 client_id（在棒鸡 Application 中查看）
		 */
		fun getAuthorizeUrl(clientId: String): HttpUrl {
			return "https://www.bungie.net/en/oauth/authorize".toHttpUrl().newBuilder()
				.addQueryParameter("response_type", "code")
				.addQueryParameter("client_id", clientId)
				.addQueryParameter("state", "1")
				.build()
		}

		fun getToken(code: String, clientId: String, clientSecret: String): Response =
			post("/App/OAuth/Token", body = Json.encodeToString(mapOf(
				"grant_type" to "authorization_code",
				"code" to code,
				"client_id" to clientId,
				"client_secret" to clientSecret
			)).toRequestBody(contentType = "application/x-www-form-urlencoded".toMediaType()))
	}

	inner class Destiny2 internal constructor() {

		fun getDestinyManifest(): DestinyManifest = get("/Destiny2/Manifest/").json.response.getTyped()

		fun getDestinyManifest(entityType: EntityType, hashIdentifier: UInt): DestinyDefinition =
			get("/Destiny2/Manifest/${entityType.name}/$hashIdentifier/").json.response.getTyped()

		fun searchDestinyPlayer(membershipType: MembershipType, displayName: String): List<UserInfoCard> =
			get("/Destiny2/SearchDestinyPlayer/${membershipType.value}/$displayName/").json.response.getTyped()

		fun getProfile(
			membershipType: MembershipType, destinyMembershipId: Long, components: List<DestinyComponentType>
		): DestinyProfileResponse = getWithQuery(
			"/Destiny2/${membershipType.value}/Profile/$destinyMembershipId/",
			mapOf("components" to components.map { it.value })
		).json.response.getTyped()

		fun getCharacter(
			membershipType: MembershipType,
			destinyMembershipId: Long,
			characterId: Long,
			components: List<DestinyComponentType>
		): DestinyCharacterResponse = getWithQuery(
			"/Destiny2/${membershipType.value}/Profile/$destinyMembershipId/Character/$characterId/",
			mapOf("components" to components.map { it.value })
		).json.response.getTyped()

		fun getItem(
			membershipType: MembershipType,
			destinyMembershipId: Long,
			itemInstanceId: Long,
			components: List<DestinyComponentType>
		): DestinyItemResponse =
			getWithQuery("/Destiny2/${membershipType.value}/Profile/$destinyMembershipId/Item/$itemInstanceId/",
				mapOf("components" to components.map { it.value })).json.response.getTyped()

		// TODO: Add other API entries
	}

	inner class Helpers internal constructor() {

		fun getBungieResource(path: String) = getResource(path)

	}

	companion object {

		/**
		 * 获取 Light.gg 的网页地址
		 */
		val HashId.lggUrl get() = "https://www.light.gg/db/items/$hash/"

	}

}

@JvmInline
value class HashId(val hash: UInt) {

	companion object {
		fun UInt.hashId() = HashId(this)
		fun String.hashId() = HashId(this.toUInt())
	}
}

val Response.json: JsonElement
	get() {
		val bodyContent = body?.string() ?: throw NullPointerException("Missing body content of the response.")
		return ktJson.parseToJsonElement(bodyContent)
	}

fun Response.getJsonKt(): JsonElement {
	val content = body?.string() ?: throw BungieException("Missing response body content.")
	return kotlin.runCatching {
		ktJson.parseToJsonElement(content)
	}.onFailure {
		logger.warn("Exception occurred on parsing following response content:")
		logger.warn(content)
		throw BungieException(it)
	}.getOrThrow()
}

private val ktJson = Json {
	isLenient = true
	prettyPrint = true
	ignoreUnknownKeys = true
	coerceInputValues = true

	serializersModule = SerializersModule {
		contextual(OffsetDateTime::class, OffsetDateTimeSerializer)
	}
}

private inline fun <reified T> JsonElement.getTyped() = runCatching {
	ktJson.decodeFromJsonElement<T>(this)
}.onFailure {
	logger.error("Unable to serialize the content follow to ${T::class.java.simpleName}:")
	logger.error(this)
}.getOrThrow()

val JsonElement.response: JsonElement
	get() = this.jsonObject.response

val JsonObject.response: JsonElement
	get() = this["Response"] ?: throw NullPointerException("Missing 'Response' in the object.")
val JsonObject.errorCode: Int?
	get() = this["ErrorCode"]?.jsonPrimitive?.int
val JsonObject.throttleSeconds: Int?
	get() = this["ThrottleSeconds"]?.jsonPrimitive?.int
val JsonObject.message: String?
	get() = this["Message"]?.jsonPrimitive?.content
val JsonObject.messageData: JsonObject?
	get() = this["MessageData"]?.jsonObject


// Helpers

fun String.toBungieResourceUrl() = "https://www.bungie.net$this"