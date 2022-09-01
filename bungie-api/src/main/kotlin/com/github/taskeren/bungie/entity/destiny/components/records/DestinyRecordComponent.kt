package com.github.taskeren.bungie.entity.destiny.components.records

import com.github.taskeren.bungie.entity.destiny.quests.DestinyObjectiveProgress
import kotlinx.serialization.Serializable

@Serializable
data class DestinyRecordComponent(
	val state: Int,
	val objectives: List<DestinyObjectiveProgress>,
	val intervalObjectives: List<DestinyObjectiveProgress>,
	val intervalsRedeemedCount: Int,
	val completedCount: Int?,
	val rewardVisibility: List<Boolean>
)