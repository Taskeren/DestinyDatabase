package com.github.taskeren.bungie.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyVendorInventoryFlyoutBucketDefinition(val collapsible: Boolean, val inventoryBucketHash: UInt, val sortItemsBy: Int)
