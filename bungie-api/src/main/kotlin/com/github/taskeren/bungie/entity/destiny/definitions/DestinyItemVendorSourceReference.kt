package com.github.taskeren.bungie.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemVendorSourceReference(val vendorHash: UInt, val vendorItemIndexes: List<Int>)
