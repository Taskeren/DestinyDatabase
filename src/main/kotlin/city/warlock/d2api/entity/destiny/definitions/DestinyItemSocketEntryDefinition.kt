package city.warlock.d2api.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemSocketEntryDefinition(
	val socketTypeHash: UInt,
	val singleInitialItemHash: UInt,
	val reusablePlugItems: List<DestinyItemSocketEntryPlugItemDefinition>,
	val preventInitializationOnVendorPurchase: Boolean,
	val hidePerksInItemTooltip: Boolean,
	val plugSources: Int,
	val reusablePlugSetHash: UInt?,
	val randomizedPlugSetHash: UInt?,
	val defaultVisible: Boolean
)
