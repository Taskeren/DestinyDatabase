package com.github.taskeren.bungie.entity.destiny.character

import com.github.taskeren.bungie.entity.destiny.DyeReference

data class DestinyItemPeerView(val itemHash: UInt, val dyes: List<DyeReference>)
