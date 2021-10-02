package city.warlock.d2api.entity.destiny.components.records

import city.warlock.d2api.entity.destiny.quests.DestinyObjectiveProgress

data class DestinyRecordComponent(
	val state: Int,
	val objectives: List<DestinyObjectiveProgress>,
	val intervalObjectives: List<DestinyObjectiveProgress>,
	val intervalsRedeemedCount: Int,
	val completedCount: Int?,
	val rewardVisibility: List<Boolean>
)