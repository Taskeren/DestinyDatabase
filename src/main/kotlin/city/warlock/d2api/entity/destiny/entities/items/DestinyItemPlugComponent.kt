package city.warlock.d2api.entity.destiny.entities.items

import city.warlock.d2api.entity.destiny.quests.DestinyObjectiveProgress

data class DestinyItemPlugComponent(
	val plugObjectives: List<DestinyObjectiveProgress>,
	val plugItemHash: UInt,
	val canInsert: Boolean,
	val enabled: Boolean,
	val insertFailIndexes: List<Int>,
	val enableFailIndexes: List<Int>
)
