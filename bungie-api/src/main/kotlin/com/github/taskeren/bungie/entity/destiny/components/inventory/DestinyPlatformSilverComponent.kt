package com.github.taskeren.bungie.entity.destiny.components.inventory

import com.github.taskeren.bungie.entity.destiny.entities.items.DestinyItemComponent
import kotlinx.serialization.Serializable

@Serializable
data class DestinyPlatformSilverComponent(val platformSilver: Map<Int, DestinyItemComponent>)
