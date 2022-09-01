package com.github.taskeren.bungie.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyVendorLocationDefinition(val destinationHash: UInt, val backgroundImagePath: String)
