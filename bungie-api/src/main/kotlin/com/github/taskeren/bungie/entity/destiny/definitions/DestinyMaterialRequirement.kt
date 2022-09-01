package com.github.taskeren.bungie.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyMaterialRequirement(val itemHash: UInt, val deleteOnAction: Boolean, val count: Int, val omitFromRequirements: Boolean)
