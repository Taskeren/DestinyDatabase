package com.github.taskeren.bungie.entity.destiny.entities.items

import com.github.taskeren.bungie.entity.destiny.quests.DestinyObjectiveProgress
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.OffsetDateTime

@Serializable
data class DestinyItemObjectivesComponent(
	val objectives: List<DestinyObjectiveProgress>,
	val flavorObjective: DestinyObjectiveProgress,
	@Contextual
	val dateCompleted: OffsetDateTime?
)
