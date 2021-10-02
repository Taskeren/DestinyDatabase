package city.warlock.d2api.entity.destiny.components.kiosks

import city.warlock.d2api.entity.destiny.definitions.DestinyVendorDefinition

data class DestinyKiosksComponent(val kioskItems: Map<UInt, DestinyVendorDefinition>)
