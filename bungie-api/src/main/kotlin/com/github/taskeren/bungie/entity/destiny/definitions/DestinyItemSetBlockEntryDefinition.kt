package com.github.taskeren.bungie.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemSetBlockEntryDefinition(val trackingValue: Int, val itemHash: UInt)
