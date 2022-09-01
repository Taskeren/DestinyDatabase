package com.github.taskeren.bungie.entity.destiny.entities.inventory

import com.github.taskeren.bungie.entity.destiny.entities.items.DestinyItemComponent
import kotlinx.serialization.Serializable

@Serializable
data class DestinyInventoryComponent(val items: List<DestinyItemComponent>)
