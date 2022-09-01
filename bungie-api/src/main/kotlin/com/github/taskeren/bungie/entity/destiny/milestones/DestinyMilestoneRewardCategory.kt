package com.github.taskeren.bungie.entity.destiny.milestones

import kotlinx.serialization.Serializable

@Serializable
data class DestinyMilestoneRewardCategory(val rewardCategoryHash: UInt, val entries: List<DestinyMilestoneRewardEntry>)
