package com.github.taskeren.bungie.entity.destiny.entities.items

import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemSocketsComponent(val sockets: List<DestinyItemSocketState>)
