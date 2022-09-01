package com.github.taskeren.bungie.entity.destiny.entities.items

import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemSocketState(val plugHash: UInt?, val isEnabled: Boolean, val isVisible: Boolean, val enableFailIndexes: List<Int>)
