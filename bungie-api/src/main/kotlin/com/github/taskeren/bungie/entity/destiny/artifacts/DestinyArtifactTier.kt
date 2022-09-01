package com.github.taskeren.bungie.entity.destiny.artifacts

import kotlinx.serialization.Serializable

@Serializable
data class DestinyArtifactTier(val tierHash: UInt, val isUnlocked: Boolean, val pointsToUnlock: Int, val items: List<DestinyArtifactTierItem>)
