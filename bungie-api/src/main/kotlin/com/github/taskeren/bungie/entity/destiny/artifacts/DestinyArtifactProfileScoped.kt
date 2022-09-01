package com.github.taskeren.bungie.entity.destiny.artifacts

import com.github.taskeren.bungie.entity.destiny.DestinyProgression
import kotlinx.serialization.Serializable

@Serializable
data class DestinyArtifactProfileScoped(
	val artifactHash: UInt,
	val pointProgression: DestinyProgression,
	val pointsAcquired: Int,
	val powerBonusProgression: DestinyProgression,
	val powerBonus: Int
)
