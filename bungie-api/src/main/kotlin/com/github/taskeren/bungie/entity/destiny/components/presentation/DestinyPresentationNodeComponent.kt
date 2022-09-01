package com.github.taskeren.bungie.entity.destiny.components.presentation

import com.github.taskeren.bungie.entity.destiny.quests.DestinyObjectiveProgress
import kotlinx.serialization.Serializable

@Serializable
data class DestinyPresentationNodeComponent(
	val state: Int,
	val objective: DestinyObjectiveProgress,
	val progressValue: Int,
	val completionValue: Int,
	val recordCategoryScore: Int?
)
