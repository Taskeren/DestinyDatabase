package com.github.taskeren.bungie.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemActionRequiredItemDefinition(val count: Int, val itemHash: UInt, val deleteOnAction: Boolean)
