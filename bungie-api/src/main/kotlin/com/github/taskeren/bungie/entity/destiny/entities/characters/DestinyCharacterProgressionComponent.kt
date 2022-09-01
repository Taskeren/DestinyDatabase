package com.github.taskeren.bungie.entity.destiny.entities.characters

import com.github.taskeren.bungie.entity.Placeholder
import com.github.taskeren.bungie.entity.destiny.DestinyProgression
import com.github.taskeren.bungie.entity.destiny.artifacts.DestinyArtifactCharacterScoped
import com.github.taskeren.bungie.entity.destiny.milestones.DestinyMilestone
import com.github.taskeren.bungie.entity.destiny.progression.DestinyFactionProgression
import com.github.taskeren.bungie.entity.destiny.quests.DestinyQuestStatus
import kotlinx.serialization.Serializable

@Serializable
data class DestinyCharacterProgressionComponent(
	val progressions: Map<UInt, DestinyProgression>,
	val factions: Map<UInt, DestinyFactionProgression>,
	val milestones: Map<UInt, DestinyMilestone>,
	val quests: List<DestinyQuestStatus>,
	val uninstancedItemObjectives: Map<UInt, List<Placeholder>>, // TODO: Figure out what the Any is (uninstancedItemObjectives)
	val checklists: Map<UInt, Placeholder>, // TODO: Figure out what the Any is (checklists)
	val seasonalArtifact: DestinyArtifactCharacterScoped
)
