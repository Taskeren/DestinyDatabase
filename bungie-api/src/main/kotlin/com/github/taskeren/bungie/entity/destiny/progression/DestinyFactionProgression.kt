package com.github.taskeren.bungie.entity.destiny.progression

import com.github.taskeren.bungie.entity.destiny.DestinyProgressionResetEntry
import kotlinx.serialization.Serializable

@Serializable
data class DestinyFactionProgression(
	val factionHash: UInt,
	val factionVendorIndex: Int,
	val progressionHash: UInt,
	val dailyProgress: Int,
	val dailyLimit: Int,
	val weeklyProgress: Int,
	val weeklyLimit: Int,
	val currentProgress: Int,
	val level: Int,
	val levelCap: Int,
	val stepIndex: Int,
	val progressToNextLevel: Int,
	val nextLevelAt: Int,
	val currentResetCount: Int?,
	val seasonResets: List<DestinyProgressionResetEntry>,
	val rewardItemStates: List<Int>
)
