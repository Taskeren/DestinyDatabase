package com.github.taskeren.bungie.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemSetBlockDefinition(
	val itemList: List<DestinyItemSetBlockEntryDefinition>,
	val requireOrderedSetItemAdd: Boolean,
	val setIsFeatured: Boolean,
	val setType: String,
	val questLineName: String,
	val questLineDescription: String,
	val questStepSummary: String
)
