package com.github.taskeren.bungie.entity.destiny.artifacts

import kotlinx.serialization.Serializable

@Serializable
data class DestinyArtifactTierItem(val itemHash: UInt, val isActive: Boolean)
