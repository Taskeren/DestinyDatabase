package com.github.taskeren.bungie.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemSocketCategoryDefinition(val socketCategoryHash: UInt, val socketIndexes: List<Int>)
