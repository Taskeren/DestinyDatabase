package city.warlock.d2api.entity.destiny.components.profiles

import java.util.*

data class DestinyProfileTransitoryTrackingEntry(
	val locationHash: UInt?,
	val itemHash: UInt?,
	val objectiveHash: UInt?,
	val activityHash: UInt?,
	val questlineItemHash: UInt?,
	val trackedDate: Date?
)
