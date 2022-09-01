package com.github.taskeren.bungie.entity.destiny.artifacts

import kotlinx.serialization.Serializable

@Serializable
data class DestinyArtifactCharacterScoped(val artifactHash: UInt, val pointsUsed: Int, val resetCount: Int, val tiers: List<DestinyArtifactTier>)
