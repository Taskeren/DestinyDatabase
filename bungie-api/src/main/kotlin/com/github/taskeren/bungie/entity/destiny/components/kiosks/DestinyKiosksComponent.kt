package com.github.taskeren.bungie.entity.destiny.components.kiosks

import com.github.taskeren.bungie.entity.destiny.definitions.DestinyVendorDefinition

data class DestinyKiosksComponent(val kioskItems: Map<UInt, DestinyVendorDefinition>)
