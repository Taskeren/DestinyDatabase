package com.github.taskeren.bungie.entity.destiny.milestones

import kotlinx.serialization.Serializable

@Serializable
data class DestinyMilestoneActivityPhase(val complete: Boolean, val phaseHash: UInt)
