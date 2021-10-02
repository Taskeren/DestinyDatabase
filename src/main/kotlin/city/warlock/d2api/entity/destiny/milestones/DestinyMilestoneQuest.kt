package city.warlock.d2api.entity.destiny.milestones

import city.warlock.d2api.entity.destiny.challenges.DestinyChallengeStatus
import city.warlock.d2api.entity.destiny.quests.DestinyQuestStatus

data class DestinyMilestoneQuest(
	val questItemHash: UInt,
	val status: DestinyQuestStatus,
	val activity: DestinyMilestoneActivity,
	val challenges: List<DestinyChallengeStatus>
)
