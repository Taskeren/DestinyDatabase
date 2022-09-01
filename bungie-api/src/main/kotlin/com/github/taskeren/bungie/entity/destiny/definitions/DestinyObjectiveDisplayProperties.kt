package com.github.taskeren.bungie.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyObjectiveDisplayProperties(val activityHash: UInt?, val displayOnItemPreviewScreen: Boolean)
