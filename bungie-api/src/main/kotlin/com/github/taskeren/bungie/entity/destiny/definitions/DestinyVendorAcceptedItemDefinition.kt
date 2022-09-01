package com.github.taskeren.bungie.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyVendorAcceptedItemDefinition(val acceptedInventoryBucketHash: UInt, val destinationInventoryBucketHash: UInt)
