package com.github.taskeren.bungie.entity.destiny.quests

import kotlinx.serialization.Serializable

@Serializable
data class DestinyObjectiveProgress(
	val objectiveHash: UInt,
	val destinationHash: UInt?,
	val activityHash: UInt?,
	val progress: Int?,
	val completionValue: Int,
	val complete: Boolean,
	val visible: Boolean
)
