package com.github.taskeren.bungie.entity.destiny.definitions

data class DestinyVendorItemDefinition(
	val vendorItemIndex: Int,
	val itemHash: UInt,
	val quantity: Int,
	val failureIndexes: List<Int>,
	val currencies: List<DestinyVendorItemQuantity>,
	val refundPolicy: Int,
	val refundTimeLimit: Int,
	val creationLevels: List<DestinyItemCreationEntryLevelDefinition>,
	val displayCategoryIndex: Int,
	val categoryIndex: Int,
	val originalCategoryIndex: Int,
	val minimumLevel: Int,
	val maximumLevel: Int,
	val action: DestinyVendorSaleItemActionBlockDefinition,
	val displayCategory: String,
	val inventoryBucketHash: UInt,
	val visibilityScope: Int,
	val purchasableScope: Int,
	val exclusivity: Int,
	val isOffer: Boolean?,
	val isCrm: Boolean?,
	val expirationTooltip: String,
	val redirectToSaleToIndexes: List<Int>,
	val socketOverrides: List<DestinyVendorItemSocketOverride>,
	val unpurchasable: Boolean?
)
