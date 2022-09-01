package com.github.taskeren.bungie.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyVendorItemQuantity(val itemHash: UInt, val itemInstanceId: Long?, val quantity: Int, val hasConditionalVisibility: Boolean)
