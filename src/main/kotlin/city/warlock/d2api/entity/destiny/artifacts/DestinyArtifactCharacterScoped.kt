package city.warlock.d2api.entity.destiny.artifacts

data class DestinyArtifactCharacterScoped(val artifactHash: UInt, val pointsUsed: Int, val resetCount: Int, val tiers: List<DestinyArtifactTier>)
