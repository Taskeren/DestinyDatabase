package com.github.taskeren.bungie.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemPreviewBlockDefinition(
	val screenStyle: String,
	val previewVendorHash: UInt,
	val artifactHash: UInt?,
	val previewActionString: String,
	val derivedItemCategories: List<DestinyDerivedItemCategoryDefinition>?
)
