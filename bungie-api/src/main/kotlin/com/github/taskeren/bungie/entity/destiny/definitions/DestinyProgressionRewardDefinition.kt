package com.github.taskeren.bungie.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyProgressionRewardDefinition(val progressionMappingHash: UInt, val amount: Int, val applyThrottles: Boolean)
