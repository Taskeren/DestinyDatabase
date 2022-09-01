package com.github.taskeren.bungie.entity.destiny.definitions

import com.github.taskeren.bungie.entity.dates.DateRange
import kotlinx.serialization.Serializable

@Serializable
data class DestinyVendorDefinition(
	val displayProperties: DestinyVendorDisplayPropertiesDefinition,
	val vendorProgressionType: Int,
	val buyString: String,
	val sellString: String,
	val displayItemHash: UInt,
	val inhibitBuying: Boolean,
	val inhibitSelling: Boolean,
	val factionHash: UInt,
	val resetIntervalMinutes: Int,
	val resetOffsetMinutes: Int,
	val failureStrings: List<String>,
	val unlockRanges: List<DateRange>,
	val vendorIdentifier: String,
	val vendorPortrait: String,
	val vendorBanner: String,
	val enabled: Boolean,
	val visible: Boolean,
	val vendorSubcategoryIdentifier: String,
	val consolidateCategories: Boolean,
	val actions: List<DestinyVendorActionDefinition>,
	val categories: List<DestinyVendorCategoryEntryDefinition>,
	val originalCategories: List<DestinyVendorCategoryEntryDefinition>,
	val displayCategories: List<DestinyDisplayCategoryDefinition>,
	val interactions: List<DestinyVendorInteractionDefinition>,
	val inventoryFlyouts: List<DestinyVendorInventoryFlyoutDefinition>,
	val itemList: List<DestinyVendorItemDefinition>,
	val service: List<DestinyVendorServiceDefinition>,
	val acceptedItems: List<DestinyVendorAcceptedItemDefinition>,
	val returnWithVendorRequest: Boolean,
	val locations: List<DestinyVendorLocationDefinition>,
	val groups: List<DestinyVendorGroupReference>,
	val ignoreSaleItemHashes: List<UInt>,
	val hash: UInt,
	val index: Int,
	val redacted: Boolean
)
