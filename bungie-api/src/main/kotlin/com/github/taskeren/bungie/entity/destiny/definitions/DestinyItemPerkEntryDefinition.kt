package com.github.taskeren.bungie.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemPerkEntryDefinition(
	val requirementDisplayString: String,
	val perkHash: UInt,
	val perkVisibility: Int
)