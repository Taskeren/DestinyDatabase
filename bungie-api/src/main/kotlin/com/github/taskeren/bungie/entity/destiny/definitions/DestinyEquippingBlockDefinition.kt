package com.github.taskeren.bungie.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyEquippingBlockDefinition(
	val gearsetItemHash: UInt?,
	val uniqueLabel: String?,
	val uniqueLabelHash: UInt,
	val equipmentSlotTypeHash: UInt,
	val attributes: Int,
	val ammoType: Int,
	val displayStrings: List<String>
)
