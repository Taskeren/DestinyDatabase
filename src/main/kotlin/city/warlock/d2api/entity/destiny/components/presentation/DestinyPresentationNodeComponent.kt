package city.warlock.d2api.entity.destiny.components.presentation

import city.warlock.d2api.entity.destiny.quests.DestinyObjectiveProgress

data class DestinyPresentationNodeComponent(
	val state: Int,
	val objective: DestinyObjectiveProgress,
	val progressValue: Int,
	val completionValue: Int,
	val recordCategoryScore: Int?
)
