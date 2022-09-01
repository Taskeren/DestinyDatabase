package com.github.taskeren.bungie.entity.destiny.milestones

import com.github.taskeren.bungie.entity.destiny.challenges.DestinyChallengeStatus
import com.github.taskeren.bungie.entity.destiny.quests.DestinyQuestStatus
import kotlinx.serialization.Serializable

@Serializable
data class DestinyMilestoneQuest(
	val questItemHash: UInt,
	val status: DestinyQuestStatus,
	val activity: DestinyMilestoneActivity,
	val challenges: List<DestinyChallengeStatus>
)
