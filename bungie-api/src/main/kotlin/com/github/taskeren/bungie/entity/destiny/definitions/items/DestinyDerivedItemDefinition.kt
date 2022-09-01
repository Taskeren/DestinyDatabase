package com.github.taskeren.bungie.entity.destiny.definitions.items

import kotlinx.serialization.Serializable

@Serializable
data class DestinyDerivedItemDefinition(
	val itemHash: UInt?,
	val itemName: String?,
	val itemDetail: String?,
	val itemDescription: String?,
	val iconPath: String?,
	val vendorItemIndex: Int
)
