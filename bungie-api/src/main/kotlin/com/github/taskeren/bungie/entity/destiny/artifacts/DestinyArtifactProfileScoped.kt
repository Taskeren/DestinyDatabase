package com.github.taskeren.bungie.entity.destiny.artifacts

import com.github.taskeren.bungie.entity.destiny.DestinyProgression

data class DestinyArtifactProfileScoped(
	val artifactHash: UInt,
	val pointProgression: DestinyProgression,
	val pointsAcquired: Int,
	val powerBonusProgression: DestinyProgression,
	val powerBonus: Int
)
