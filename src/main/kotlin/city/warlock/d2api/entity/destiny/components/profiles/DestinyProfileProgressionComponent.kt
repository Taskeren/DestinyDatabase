package city.warlock.d2api.entity.destiny.components.profiles

import city.warlock.d2api.entity.destiny.artifacts.DestinyArtifactProfileScoped

data class DestinyProfileProgressionComponent(val checklists: Map<UInt, Any>, val seasonalArtifact: DestinyArtifactProfileScoped) // TODO: Discover what Any is
