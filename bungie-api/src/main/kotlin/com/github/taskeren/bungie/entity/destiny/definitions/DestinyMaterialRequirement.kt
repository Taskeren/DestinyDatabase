package com.github.taskeren.bungie.entity.destiny.definitions

data class DestinyMaterialRequirement(val itemHash: UInt, val deleteOnAction: Boolean, val count: Int, val omitFromRequirements: Boolean)
