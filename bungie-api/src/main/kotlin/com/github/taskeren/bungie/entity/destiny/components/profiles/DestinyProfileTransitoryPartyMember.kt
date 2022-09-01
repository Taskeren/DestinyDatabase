package com.github.taskeren.bungie.entity.destiny.components.profiles

import kotlinx.serialization.Serializable

@Serializable
data class DestinyProfileTransitoryPartyMember(val membershipId: Long, val emblemHash: UInt, val displayName: String, val status: Int)