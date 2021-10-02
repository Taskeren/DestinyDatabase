package city.warlock

import com.google.gson.*
import org.litote.kmongo.json

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