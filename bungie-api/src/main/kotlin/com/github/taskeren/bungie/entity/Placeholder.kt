package com.github.taskeren.bungie.entity

import kotlinx.serialization.*
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonElement

/**
 * 仅作为占位符使用的类型，数据内容会被解析到 [value] 中。
 *
 * 当明确类型后应当创建对应的 data class 而不是继续使用 [Placeholder]。
 */
@Serializable(with = PlaceholderSerializer::class)
data class Placeholder(val value: JsonElement?)

@OptIn(ExperimentalSerializationApi::class)
@Serializer(Placeholder::class)
object PlaceholderSerializer {
	override fun deserialize(decoder: Decoder): Placeholder {
		return when(decoder) {
			is JsonDecoder -> Placeholder(decoder.decodeJsonElement())
			else -> Placeholder(null)
		}
	}
}
