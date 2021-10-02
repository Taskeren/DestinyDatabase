package city.warlock.d2api.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemSocketCategoryDefinition(val socketCategoryHash: UInt, val socketIndexes: List<Int>)
