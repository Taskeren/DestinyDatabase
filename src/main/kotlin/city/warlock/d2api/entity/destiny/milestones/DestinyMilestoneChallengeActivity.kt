package city.warlock.d2api.entity.destiny.milestones

import city.warlock.d2api.entity.destiny.challenges.DestinyChallengeStatus

data class DestinyMilestoneChallengeActivity(
	val activityHash: UInt,
	val challenges: List<DestinyChallengeStatus>,
	val modifierHashes: List<UInt>,
	val booleanActivityOptions: Map<UInt, Boolean>,
	val loadoutRequirementIndex: Int?,
	val phase: List<DestinyMilestoneActivityPhase>
)
