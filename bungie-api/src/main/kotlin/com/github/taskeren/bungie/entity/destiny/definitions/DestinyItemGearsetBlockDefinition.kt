package com.github.taskeren.bungie.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemGearsetBlockDefinition(val trackingValueMax: Int, val itemList: List<UInt>)