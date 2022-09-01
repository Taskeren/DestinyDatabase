package com.github.taskeren.bungie.entity.destiny.components.profiles

import com.github.taskeren.bungie.entity.Placeholder
import com.github.taskeren.bungie.entity.destiny.artifacts.DestinyArtifactProfileScoped
import kotlinx.serialization.Serializable

@Serializable
data class DestinyProfileProgressionComponent(val checklists: Map<UInt, Placeholder>, val seasonalArtifact: DestinyArtifactProfileScoped) // TODO: Discover what Any is
