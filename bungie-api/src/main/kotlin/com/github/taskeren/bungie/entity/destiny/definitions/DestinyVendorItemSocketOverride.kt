package com.github.taskeren.bungie.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyVendorItemSocketOverride(val singleItemHash: UInt, val randomizedOptionsCount: Int, val socketTypeHash: UInt)
