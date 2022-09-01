package com.github.taskeren.bungie.entity.destiny.entities.items

import com.github.taskeren.bungie.entity.destiny.DestinyStat
import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemStatsComponent(val stats: Map<UInt, DestinyStat>)
