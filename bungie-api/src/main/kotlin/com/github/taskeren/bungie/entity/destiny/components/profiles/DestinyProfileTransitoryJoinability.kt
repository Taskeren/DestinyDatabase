package com.github.taskeren.bungie.entity.destiny.components.profiles

import kotlinx.serialization.Serializable

@Serializable
data class DestinyProfileTransitoryJoinability(val openSlots: Int, val privacySetting: Int, val closedReasons: Int)
