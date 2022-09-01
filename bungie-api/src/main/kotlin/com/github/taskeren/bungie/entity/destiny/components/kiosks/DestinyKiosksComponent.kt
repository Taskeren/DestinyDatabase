package com.github.taskeren.bungie.entity.destiny.components.kiosks

import com.github.taskeren.bungie.entity.destiny.definitions.DestinyVendorDefinition
import kotlinx.serialization.Serializable

@Serializable
data class DestinyKiosksComponent(val kioskItems: Map<UInt, DestinyVendorDefinition>)
