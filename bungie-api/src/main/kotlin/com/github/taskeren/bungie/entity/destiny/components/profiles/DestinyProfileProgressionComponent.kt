package com.github.taskeren.bungie.entity.destiny.components.profiles

import com.github.taskeren.bungie.entity.destiny.artifacts.DestinyArtifactProfileScoped

data class DestinyProfileProgressionComponent(val checklists: Map<UInt, Any>, val seasonalArtifact: DestinyArtifactProfileScoped) // TODO: Discover what Any is
