package city.warlock.d2api.entity.destiny.definitions

data class DestinyVendorCategoryEntryDefinition(
	val categoryIndex: Int,
	val sortValue: Int,
	val categoryHash: UInt,
	val quantityAvailable: Int,
	val showUnavailableItems: Boolean,
	val hideIfNoCurrency: Boolean,
	val hideFromRegularPurchase: Boolean,
	val buyStringOverride: String,
	val disabledDescription: String,
	val displayTitle: String,
	val overlay: DestinyVendorCategoryOverlayDefinition,
	val vendorItemIndexes: List<Int>,
	val isPreview: Boolean,
	val isDisplayOnly: Boolean,
	val resetIntervalMinutesOverride: Int,
	val resetOffsetMinutesOverride: Int
)
