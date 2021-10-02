package city.warlock.d2api.entity.destiny.definitions.items

import kotlinx.serialization.Serializable

@Serializable
data class DestinyEnergyCostEntry(val energyCost: Int, val energyTypeHash: UInt, val energyType: Int)