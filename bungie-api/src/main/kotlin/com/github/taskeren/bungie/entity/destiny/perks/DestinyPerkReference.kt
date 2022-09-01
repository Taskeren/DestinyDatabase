package com.github.taskeren.bungie.entity.destiny.perks

import kotlinx.serialization.Serializable

@Serializable
data class DestinyPerkReference(val perkHash: UInt, val iconPath: String, val isActive: Boolean, val visible: Boolean)
