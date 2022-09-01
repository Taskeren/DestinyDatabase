package com.github.taskeren.bungie.entity.destiny.milestones

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.OffsetDateTime

@Serializable
data class DestinyMilestone(
	val milestoneHash: UInt,
	val availableQuests: List<DestinyMilestoneQuest>,
	val activities: List<DestinyMilestoneChallengeActivity>,
	val values: Map<String, Float>,
	val vendorHashes: List<UInt>,
	val vendors: List<DestinyMilestoneVendor>,
	val rewards: List<DestinyMilestoneRewardCategory>,
	@Contextual
	val startDate: OffsetDateTime?,
	@Contextual
	val endDate: OffsetDateTime?,
	val order: Int
)
