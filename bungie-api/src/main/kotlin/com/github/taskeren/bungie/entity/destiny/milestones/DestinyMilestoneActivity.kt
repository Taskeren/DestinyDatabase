package com.github.taskeren.bungie.entity.destiny.milestones

import kotlinx.serialization.Serializable

@Serializable
data class DestinyMilestoneActivity(
	val activityHash: UInt,
	val activityModeHash: UInt?,
	val activityModeType: Int?,
	val modifierHashes: List<UInt>,
	val variants: List<DestinyMilestoneActivityVariant>
) {
	fun enumActivityModeType(): DestinyModeTypeEnum? = activityModeType?.toDestinyModeType()
}
