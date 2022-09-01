package com.github.taskeren.bungie.entity.destiny.artifacts

data class DestinyArtifactCharacterScoped(val artifactHash: UInt, val pointsUsed: Int, val resetCount: Int, val tiers: List<DestinyArtifactTier>)
