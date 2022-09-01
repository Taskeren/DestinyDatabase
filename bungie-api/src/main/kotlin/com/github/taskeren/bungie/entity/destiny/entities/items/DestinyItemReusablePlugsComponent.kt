package com.github.taskeren.bungie.entity.destiny.entities.items

import com.github.taskeren.bungie.entity.Placeholder
import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemReusablePlugsComponent(val plugs: Map<Int, List<Placeholder>>) // TODO: Figure out what Any is
