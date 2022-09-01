package com.github.taskeren.bungie.entity.destiny.components.profiles

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.OffsetDateTime

@Serializable
data class DestinyProfileTransitoryTrackingEntry(
	val locationHash: UInt?,
	val itemHash: UInt?,
	val objectiveHash: UInt?,
	val activityHash: UInt?,
	val questlineItemHash: UInt?,
	@Contextual
	val trackedDate: OffsetDateTime?
)
