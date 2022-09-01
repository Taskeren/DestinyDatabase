package com.github.taskeren.bungie.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyDefinition(val hash: UInt, val index: Int, val redacted: Boolean)