package com.github.taskeren.bungie.entity.destiny

import com.github.taskeren.bungie.entity.destiny.challenges.DestinyChallengeStatus
import kotlinx.serialization.Serializable

@Serializable
data class DestinyActivity(
	val activityHash: UInt,
	val isNew: Boolean,
	val canLead: Boolean,
	val canJoin: Boolean,
	val isCompleted: Boolean,
	val isVisible: Boolean,
	val displayLevel: Int?,
	val recommendedLight: Int?,
	val difficultyTier: Int,
	val challenges: List<DestinyChallengeStatus>,
	val modifierHashes: List<UInt>,
	val booleanActivityOptions: Map<UInt, Boolean>,
	val loadoutRequirementIndex: Int?
)
