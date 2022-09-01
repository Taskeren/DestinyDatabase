package com.github.taskeren.bungie.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemStatBlockDefinition(
	val disablePrimaryStatDisplay: Boolean,
	val statGroupHash: UInt?,
	val stats: Map<UInt, DestinyInventoryItemStatDefinition>,
	val hasDisplayableStats: Boolean,
	val primaryBaseStatHash: UInt
)