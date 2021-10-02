package city.warlock.d2api.entity.destiny.milestones

import java.util.*

data class DestinyMilestone(
	val milestoneHash: UInt,
	val availableQuests: List<DestinyMilestoneQuest>,
	val activities: List<DestinyMilestoneChallengeActivity>,
	val values: Map<String, Float>,
	val vendorHashes: List<UInt>,
	val vendors: List<DestinyMilestoneVendor>,
	val rewards: List<DestinyMilestoneRewardCategory>,
	val startDate: Date?,
	val endDate: Date?,
	val order: Int
)
