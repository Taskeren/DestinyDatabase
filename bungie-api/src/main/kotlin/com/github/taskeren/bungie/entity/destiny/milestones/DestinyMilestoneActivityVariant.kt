package com.github.taskeren.bungie.entity.destiny.milestones

data class DestinyMilestoneActivityVariant(
	val activityHash: UInt,
	val completionStatus: DestinyMilestoneActivityCompletionStatus,
	val activityModeHash: UInt?,
	val activityModeType: Int?
) {
	fun enumActivityModeType(): DestinyModeTypeEnum? = activityModeType?.toDestinyModeType()
}
