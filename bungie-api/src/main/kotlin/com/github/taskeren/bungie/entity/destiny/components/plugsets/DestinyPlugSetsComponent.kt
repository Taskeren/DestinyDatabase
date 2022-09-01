package com.github.taskeren.bungie.entity.destiny.components.plugsets

import com.github.taskeren.bungie.entity.Placeholder
import kotlinx.serialization.Serializable

@Serializable
data class DestinyPlugSetsComponent(val plugs: Map<UInt, List<Placeholder>>) // TODO: Get what type is Any
