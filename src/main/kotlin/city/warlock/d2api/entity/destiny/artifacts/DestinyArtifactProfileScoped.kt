package city.warlock.d2api.entity.destiny.artifacts

import city.warlock.d2api.entity.destiny.DestinyProgression

data class DestinyArtifactProfileScoped(
	val artifactHash: UInt,
	val pointProgression: DestinyProgression,
	val pointsAcquired: Int,
	val powerBonusProgression: DestinyProgression,
	val powerBonus: Int
)
