package com.github.taskeren.bungie.entity.destiny.definitions.items

import kotlinx.serialization.Serializable

@Serializable
data class DestinyEnergyCostEntry(val energyCost: Int, val energyTypeHash: UInt, val energyType: Int)