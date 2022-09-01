package com.github.taskeren.bungie.entity.destiny

import kotlinx.serialization.Serializable

@Serializable
data class DestinyProgressionResetEntry(val season: Int, val resets: Int)
