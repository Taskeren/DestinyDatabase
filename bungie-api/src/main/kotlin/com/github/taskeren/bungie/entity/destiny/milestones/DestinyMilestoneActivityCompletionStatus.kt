package com.github.taskeren.bungie.entity.destiny.milestones

import kotlinx.serialization.Serializable

@Serializable
data class DestinyMilestoneActivityCompletionStatus(val completed: Boolean, val phases: List<DestinyMilestoneActivityPhase>)
