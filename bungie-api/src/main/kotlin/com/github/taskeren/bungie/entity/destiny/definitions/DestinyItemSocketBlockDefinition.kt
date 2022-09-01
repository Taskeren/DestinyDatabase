package com.github.taskeren.bungie.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemSocketBlockDefinition(
	val detail: String,
	val socketEntries: List<DestinyItemSocketEntryDefinition>,
	val intrinsicSockets: List<DestinyItemIntrinsicSocketEntryDefinition>,
	val socketCategories: List<DestinyItemSocketCategoryDefinition>
)