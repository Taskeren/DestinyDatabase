package com.github.taskeren.bungie.entity.destiny.character

import com.github.taskeren.bungie.entity.destiny.DyeReference
import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemPeerView(val itemHash: UInt, val dyes: List<DyeReference>)
