package city.warlock.d2api.entity.destiny.definitions

import city.warlock.d2api.entity.destiny.definitions.common.DestinyDisplayPropertiesDefinition

data class DestinyVendorInventoryFlyoutDefinition(
	val lockedDescription: String,
	val displayProperties: DestinyDisplayPropertiesDefinition,
	val buckets: List<DestinyVendorInventoryFlyoutBucketDefinition>,
	val flyoutId: UInt,
	val suppressNewness: Boolean,
	val equipmentSlotHash: UInt?
)
