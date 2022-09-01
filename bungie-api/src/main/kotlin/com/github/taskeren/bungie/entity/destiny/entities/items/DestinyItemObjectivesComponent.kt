package com.github.taskeren.bungie.entity.destiny.entities.items

import com.github.taskeren.bungie.entity.destiny.quests.DestinyObjectiveProgress
import java.util.*

data class DestinyItemObjectivesComponent(val objectives: List<DestinyObjectiveProgress>, val flavorObjective: DestinyObjectiveProgress, val dateCompleted: Date?)
