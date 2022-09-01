package com.github.taskeren.bungie.entity.destiny.components.metrics

import com.github.taskeren.bungie.entity.destiny.quests.DestinyObjectiveProgress
import kotlinx.serialization.Serializable

@Serializable
data class DestinyMetricComponent(val invisible: Boolean, val objectiveProgress: DestinyObjectiveProgress)