package city.warlock.d2api.entity.destiny.components.profiles

data class DestinyProfileTransitoryComponent(
	val partyMembers: List<DestinyProfileTransitoryPartyMember>,
	val currentActivity: DestinyProfileTransitoryCurrentActivity,
	val joinability: DestinyProfileTransitoryJoinability,
	val tracking: List<DestinyProfileTransitoryTrackingEntry>,
	val lastOrbitedDestinationHash: UInt
)
