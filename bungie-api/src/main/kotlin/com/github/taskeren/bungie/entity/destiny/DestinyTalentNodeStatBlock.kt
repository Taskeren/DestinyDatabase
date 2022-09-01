package com.github.taskeren.bungie.entity.destiny

import kotlinx.serialization.Serializable

@Serializable
data class DestinyTalentNodeStatBlock(val currentStepStats: List<DestinyStat>, val nextStepStats: List<DestinyStat>)
