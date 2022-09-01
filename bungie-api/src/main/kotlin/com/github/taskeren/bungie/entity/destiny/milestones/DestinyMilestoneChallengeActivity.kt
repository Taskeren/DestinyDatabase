package com.github.taskeren.bungie.entity.destiny.milestones

import com.github.taskeren.bungie.entity.destiny.challenges.DestinyChallengeStatus
import kotlinx.serialization.Serializable

@Serializable
data class DestinyMilestoneChallengeActivity(
	val activityHash: UInt,
	val challenges: List<DestinyChallengeStatus>,
	val modifierHashes: List<UInt>,
	val booleanActivityOptions: Map<UInt, Boolean>,
	val loadoutRequirementIndex: Int?,
	val phase: List<DestinyMilestoneActivityPhase>
)
