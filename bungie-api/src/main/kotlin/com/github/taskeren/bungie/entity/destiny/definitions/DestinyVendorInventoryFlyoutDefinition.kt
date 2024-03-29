package com.github.taskeren.bungie.entity.destiny.definitions

import com.github.taskeren.bungie.entity.destiny.definitions.common.DestinyDisplayPropertiesDefinition
import kotlinx.serialization.Serializable

@Serializable
data class DestinyVendorInventoryFlyoutDefinition(
	val lockedDescription: String,
	val displayProperties: DestinyDisplayPropertiesDefinition,
	val buckets: List<DestinyVendorInventoryFlyoutBucketDefinition>,
	val flyoutId: UInt,
	val suppressNewness: Boolean,
	val equipmentSlotHash: UInt?
)
