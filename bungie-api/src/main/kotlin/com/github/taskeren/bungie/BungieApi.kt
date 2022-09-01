package com.github.taskeren.bungie

import com.github.taskeren.bungie.compat.EntityType
import com.github.taskeren.bungie.entity.MembershipType
import com.github.taskeren.bungie.entity.destiny.DestinyComponentType
import com.github.taskeren.bungie.entity.destiny.config.DestinyManifest
import com.github.taskeren.bungie.entity.destiny.definitions.DestinyDefinition
import com.github.taskeren.bungie.entity.destiny.definitions.DestinyInventoryItemDefinition
import com.github.taskeren.bungie.entity.destiny.responses.*
import com.github.taskeren.bungie.entity.user.UserInfoCard
import com.github.taskeren.tserial.OffsetDateTimeSerializer
import kotlinx.serialization.json.*
import kotlinx.serialization.modules.SerializersModule
import okhttp3.*
import org.apache.logging.log4j.LogManager
import java.net.URLEncoder
import java.time.OffsetDateTime

private val logger = LogManager.getLogger("BungieApi")

object BungieApi {

	private val cli = OkHttpClient()

	var xApiKey = ""
	var debugMode = false

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
							// Joiner.on(',').skipNulls().join(queryEntity)
							this.addQueryParameter(queryName, queryValue)
						} else {
							throw BungieException("Unexpected type of queries: ${queryEntity.javaClass.canonicalName}")
						}
					}
				}.build()

		val req = Request.Builder().get().url(httpUrl).header("X-API-Key", xApiKey).build()
		return cli.newCall(req).execute()
	}

	private fun getResource(url: String): Response {
		val req = Request.Builder().get().url("https://www.bungie.net$url").header("X-API-Key", xApiKey).build()
		return cli.newCall(req).execute()
	}

	object Destiny2 {

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

	object Helpers {

		fun getBungieResource(path: String): Response = getResource(path)

		/**
		 * @see DestinyInventoryItemDefinition.getLightGGUrl
		 */
		fun getLightGGUrl(hash: UInt): String = "https://www.light.gg/db/items/$hash/"

	}

}

fun Response.getString(): String {
	val str = this.body?.string()
	if(BungieApi.debugMode) println(str)
	return str ?: throw BungieException(NullPointerException("Body"))
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

@Deprecated("old")
fun Response.getKtJson(): JsonElement {
	val json = runCatching {
		ktJson.parseToJsonElement(
			this.body?.string() ?: throw NullPointerException("Body")
		)
	}.onFailure { throw BungieException(it) }.getOrNull()
	if(BungieApi.debugMode) println(json)
	return json ?: throw NullPointerException("KtJsonElement")
}

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