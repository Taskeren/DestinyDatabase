package com.github.taskeren.bungie.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemIntrinsicSocketEntryDefinition(
	val plugItemHash: UInt,
	val socketTypeHash: UInt,
	val defaultVisible: Boolean
)