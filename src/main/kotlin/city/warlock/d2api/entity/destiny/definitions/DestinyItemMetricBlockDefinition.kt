package city.warlock.d2api.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemMetricBlockDefinition(val availableMetricCategoryNodeHashes: List<UInt>)
