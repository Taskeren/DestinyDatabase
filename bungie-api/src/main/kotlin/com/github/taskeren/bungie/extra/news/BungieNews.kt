package com.github.taskeren.bungie.extra.news

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.OffsetDateTime

@Serializable
data class BungieNews(
	val title: String,
	val subtitle: String,
	val uid: String,
	val url: BungieNewsUrls,
	@Contextual
	val date: OffsetDateTime,
)

@Serializable
data class BungieNewsUrls(
	@SerialName("hosted_url")
	val hostedUrl: String,
)