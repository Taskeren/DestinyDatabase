package com.github.taskeren.bungie.entity.destiny.components.stringVariables

import kotlinx.serialization.Serializable

@Serializable
data class DestinyStringVariablesComponent(val integerValuesByHash: Map<UInt, Int>)
