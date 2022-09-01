package com.github.taskeren.bungie.entity.destiny.entities.items

import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemRenderComponent(val useCustomDyes: Boolean, val artRegions: Map<Int, Int>)
