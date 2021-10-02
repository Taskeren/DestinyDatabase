package city.warlock.d2api.entity.destiny.components.profiles

import java.util.*

data class DestinyProfileTransitoryCurrentActivity(
	val startTime: Date?,
	val endTime: Date?,
	val score: Float,
	val highestOpposingFactionScore: Float,
	val numberOfOpponents: Int,
	val numberOfPlayers: Int
)
