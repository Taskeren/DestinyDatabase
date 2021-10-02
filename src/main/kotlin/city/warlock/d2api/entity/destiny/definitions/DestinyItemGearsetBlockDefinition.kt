package city.warlock.d2api.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemGearsetBlockDefinition(val trackingValueMax: Int, val itemList: List<UInt>)