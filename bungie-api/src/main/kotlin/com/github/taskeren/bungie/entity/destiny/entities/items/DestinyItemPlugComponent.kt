package com.github.taskeren.bungie.entity.destiny.entities.items

import com.github.taskeren.bungie.entity.destiny.quests.DestinyObjectiveProgress
import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemPlugComponent(
	val plugObjectives: List<DestinyObjectiveProgress>,
	val plugItemHash: UInt,
	val canInsert: Boolean,
	val enabled: Boolean,
	val insertFailIndexes: List<Int>,
	val enableFailIndexes: List<Int>
)
