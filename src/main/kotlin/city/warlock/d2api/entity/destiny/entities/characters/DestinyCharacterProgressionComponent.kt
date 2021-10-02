package city.warlock.d2api.entity.destiny.entities.characters

import city.warlock.d2api.entity.destiny.DestinyProgression
import city.warlock.d2api.entity.destiny.artifacts.DestinyArtifactCharacterScoped
import city.warlock.d2api.entity.destiny.milestones.DestinyMilestone
import city.warlock.d2api.entity.destiny.progression.DestinyFactionProgression
import city.warlock.d2api.entity.destiny.quests.DestinyQuestStatus

data class DestinyCharacterProgressionComponent(
	val progressions: Map<UInt, DestinyProgression>,
	val factions: Map<UInt, DestinyFactionProgression>,
	val milestones: Map<UInt, DestinyMilestone>,
	val quests: List<DestinyQuestStatus>,
	val uninstancedItemObjectives: Map<UInt, List<Any>>, // TODO: Figure out what the Any is (uninstancedItemObjectives)
	val checklists: Map<UInt, Any>, // TODO: Figure out what the Any is (checklists)
	val seasonalArtifact: DestinyArtifactCharacterScoped
)
