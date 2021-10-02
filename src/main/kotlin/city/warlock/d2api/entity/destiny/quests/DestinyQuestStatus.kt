package city.warlock.d2api.entity.destiny.quests

data class DestinyQuestStatus(
	val questHash: UInt,
	val stepHash: UInt,
	val stepObjectives: List<DestinyObjectiveProgress>,
	val tracked: Boolean,
	val itemInstanceId: Long,
	val completed: Boolean,
	val redeemed: Boolean,
	val started: Boolean,
	val vendorHash: UInt?
)
