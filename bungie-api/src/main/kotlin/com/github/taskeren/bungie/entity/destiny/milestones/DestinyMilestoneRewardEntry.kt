package com.github.taskeren.bungie.entity.destiny.milestones

import kotlinx.serialization.Serializable

@Serializable
data class DestinyMilestoneRewardEntry(val rewardEntryHash: UInt, val earned: Boolean, val redeemed: Boolean)
