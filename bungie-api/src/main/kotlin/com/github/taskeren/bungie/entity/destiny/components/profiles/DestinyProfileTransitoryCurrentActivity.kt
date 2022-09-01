package com.github.taskeren.bungie.entity.destiny.components.profiles

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.OffsetDateTime

@Serializable
data class DestinyProfileTransitoryCurrentActivity(
	@Contextual
	val startTime: OffsetDateTime?,
	@Contextual
	val endTime: OffsetDateTime?,
	val score: Float,
	val highestOpposingFactionScore: Float,
	val numberOfOpponents: Int,
	val numberOfPlayers: Int
)
