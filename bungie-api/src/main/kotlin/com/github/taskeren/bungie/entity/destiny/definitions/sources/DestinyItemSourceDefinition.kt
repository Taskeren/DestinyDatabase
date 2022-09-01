package com.github.taskeren.bungie.entity.destiny.definitions.sources

import com.github.taskeren.bungie.entity.destiny.definitions.DestinyInventoryItemStatDefinition
import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemSourceDefinition(
	val level: Int,
	val minQuality: Int,
	val maxQuality: Int,
	val minLevelRequired: Int,
	val maxLevelRequired: Int,
	val computedStats: Map<UInt, DestinyInventoryItemStatDefinition>,
	val sourceHashes: List<UInt>
)