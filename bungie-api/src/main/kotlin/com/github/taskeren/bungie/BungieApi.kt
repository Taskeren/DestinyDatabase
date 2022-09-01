package com.github.taskeren.bungie

import com.github.taskeren.bungie.compat.EntityType
import com.github.taskeren.bungie.entity.MembershipType
import com.github.taskeren.bungie.entity.destiny.DestinyComponentType
import com.github.taskeren.bungie.entity.destiny.config.DestinyManifest
import com.github.taskeren.bungie.entity.destiny.definitions.DestinyDefinition
import com.github.taskeren.bungie.entity.destiny.definitions.DestinyInventoryItemDefinition
import com.github.taskeren.bungie.entity.user.UserInfoCard
import com.github.taskeren.bungie.entity.destiny.responses.*
import com.google.common.base.Joiner
import com.google.gson.*
import com.google.gson.reflect.TypeToken
import kotlinx.serialization.json.Json
import okhttp3.*
import org.apache.logging.log4j.LogManager
import org.bson.Document
import java.net.URLEncoder

private val logger = LogManager.getLogger("BungieApi")

object BungieApi {

	private val cli = OkHttpClient()
	private val gson = Gson()

	var xApiKey = ""
	var debugMode = false

	private fun get(url: String): Response {
		val req = Request.Builder()
			.get()
			.url("https://www.bungie.net/Platform${URLEncoder.encode(url, "utf-8")}")
			.header("X-API-Key", xApiKey)
			.build()
		return cli.newCall(req).execute()
	}

	private fun getWithQuery(url: String, query: Map<String, Any>): Response {
		val httpUrl = HttpUrl.Builder()
			.scheme("https")
			.host("www.bungie.net")
			.addPathSegments("/Platform/")
			.addPathSegment(url)
			.apply {
				query.forEach { (queryName, queryEntity) ->
					if(queryEntity is Iterable<*>) {
						this.addQueryParameter(queryName, Joiner.on(',').skipNulls().join(queryEntity))
					} else {
						throw BungieException("Unexpected type of queries: ${queryEntity.javaClass.canonicalName}")
					}
				}
			}
			.build()

		val req = Request.Builder()
			.get()
			.url(httpUrl)
			.header("X-API-Key", xApiKey)
			.build()
		return cli.newCall(req).execute()
	}

	private fun getResource(url: String): Response {
		val req = Request.Builder()
			.get().url("https://www.bungie.net$url").header("X-API-Key", xApiKey).build()
		return cli.newCall(req).execute()
	}

	object Destiny2 {

		fun getDestinyManifest(): DestinyManifest =
			get("/Destiny2/Manifest/").getJson().getResponse().getTyped()

		fun getDestinyManifest(entityType: EntityType, hashIdentifier: UInt): DestinyDefinition =
			get("/Destiny2/Manifest/${entityType.name}/$hashIdentifier/").getJson().getResponse().getTyped()

		fun searchDestinyPlayer(membershipType: MembershipType, displayName: String): List<UserInfoCard> =
			get("/Destiny2/SearchDestinyPlayer/${membershipType.value}/$displayName/").getJson().getResponse()
				.getTypedList()

		fun getProfile(
			membershipType: MembershipType, destinyMembershipId: Long,
			components: List<DestinyComponentType>
		): DestinyProfileResponse =
			getWithQuery(
				"/Destiny2/${membershipType.value}/Profile/$destinyMembershipId/",
				mapOf("components" to components.map { it.value })
			).getJson().getResponse().getTyped()

		fun getCharacter(
			membershipType: MembershipType,
			destinyMembershipId: Long,
			characterId: Long,
			components: List<DestinyComponentType>
		): DestinyCharacterResponse =
			getWithQuery(
				"/Destiny2/${membershipType.value}/Profile/$destinyMembershipId/Character/$characterId/",
				mapOf(
					"components" to components.map { it.value })
			).getJson().getResponse().getTyped()

		fun getItem(
			membershipType: MembershipType,
			destinyMembershipId: Long,
			itemInstanceId: Long,
			components: List<DestinyComponentType>
		): DestinyItemResponse =
			getWithQuery(
				"/Destiny2/${membershipType.value}/Profile/$destinyMembershipId/Item/$itemInstanceId/",
				mapOf(
					"components" to components.map { it.value }
				)
			).getJson().getResponse().getTyped()

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

val GSON = Gson()

fun Response.getString(): String {
	val str = this.body?.string()
	if(BungieApi.debugMode) println(str)
	return str ?: throw BungieException(NullPointerException("Body"))
}

fun Response.getJson(): JsonElement {
	val json = runCatching { JsonParser.parseReader(this.body?.charStream()) }
		.onFailure { throw BungieException(it) }.getOrNull()
	if(BungieApi.debugMode) println(json)
	return json ?: throw BungieException(NullPointerException("JsonElement"))
}

fun Response.getDocument(): Document {
	val doc = runCatching { Document.parse(this.body?.string()) }.onFailure {
		throw BungieException(it) }.getOrNull()
	if(BungieApi.debugMode) println(doc)
	return doc ?: throw BungieException(NullPointerException("Document"))
}

private val ktJson = Json {
	ignoreUnknownKeys = true
}

fun Response.getKtJson(): kotlinx.serialization.json.JsonElement {
	val json = runCatching { ktJson.parseToJsonElement(this.body?.string() ?: throw NullPointerException("Body")) }
		.onFailure { throw BungieException(it) }.getOrNull()
	if(BungieApi.debugMode) println(json)
	return json ?: throw NullPointerException("KtJsonElement")
}

fun JsonElement.getResponse(): JsonElement = asJsonObject.get("Response") ?: throw BungieException("No Response => (${getErrorCode()}) ${getMessage()}", NullPointerException("Value of '#.Response' in response of API is null."))

fun JsonElement.getErrorCode(): Int = asJsonObject.pri("ErrorCode")!!.asInt
fun JsonElement.getThrottleSeconds(): Int = asJsonObject.pri("ThrottleSeconds")!!.asInt
fun JsonElement.getErrorStatus(): String = asJsonObject.pri("ErrorStatus")!!.asString
fun JsonElement.getMessage(): String = asJsonObject.pri("Message")!!.asString
fun JsonElement.getMessageData(): JsonObject = asJsonObject.sub("MessageData")!!

inline fun <reified T> JsonElement.getTyped(): T = GSON.fromJson(this, T::class.java)
inline fun <reified T> JsonElement.getTypedList(): List<T> = GSON.fromJson(this, (object : TypeToken<List<T>>() {}.type)) // https://stackoverflow.com/questions/27253555/com-google-gson-internal-linkedtreemap-cannot-be-cast-to-my-class


// Helpers

fun String.toBungieResourceUrl() = "https://www.bungie.net$this"

// legacies from HappyCoding.kt

fun <T, R> T?.runNotNull(block: T.() -> R): R? {
	return if(this != null) block.invoke(this) else this
}

fun <T, R> T?.letNotNull(block: (T) -> R): R? {
	return if(this != null) block.invoke(this) else this
}

// Gson

fun <R> JsonElement.ifObject(block: (JsonObject) -> R): R? {
	return if(this.isJsonObject) block.invoke(this.asJsonObject) else null
}

fun <R> JsonElement.ifArray(block: (JsonArray) -> R): R? {
	return if(this.isJsonArray) block.invoke(this.asJsonArray) else null
}

fun <R> JsonElement.ifPrimitive(block: (JsonPrimitive) -> R): R? {
	return if(this.isJsonPrimitive) block.invoke(this.asJsonPrimitive) else null
}

fun JsonObject?.sub(memberName: String): JsonObject?    = this?.getAsJsonObject(memberName)
fun JsonObject?.arr(memberName: String): JsonArray?     = this?.getAsJsonArray(memberName)
fun JsonObject?.pri(memberName: String): JsonPrimitive? = this?.getAsJsonPrimitive(memberName)