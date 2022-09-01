package com.github.taskeren.bungie.entity.destiny.components.profiles

import kotlinx.serialization.Serializable

@Serializable
data class DestinyProfileTransitoryComponent(
	val partyMembers: List<DestinyProfileTransitoryPartyMember>,
	val currentActivity: DestinyProfileTransitoryCurrentActivity,
	val joinability: DestinyProfileTransitoryJoinability,
	val tracking: List<DestinyProfileTransitoryTrackingEntry>,
	val lastOrbitedDestinationHash: UInt
)
