package city.warlock.d2api.entity.destiny.milestones

data class DestinyMilestoneActivityVariant(
	val activityHash: UInt,
	val completionStatus: DestinyMilestoneActivityCompletionStatus,
	val activityModeHash: UInt?,
	val activityModeType: Int?
) {
	fun enumActivityModeType(): DestinyModeTypeEnum? = activityModeType?.toDestinyModeType()
}
