package com.github.taskeren.bungie.entity.destiny.challenges

import com.github.taskeren.bungie.entity.destiny.quests.DestinyObjectiveProgress
import kotlinx.serialization.Serializable

@Serializable
data class DestinyChallengeStatus(val objective: DestinyObjectiveProgress)
