package city.warlock.d2api.entity.destiny.definitions.sources

import city.warlock.d2api.entity.destiny.definitions.DestinyInventoryItemStatDefinition
import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemSourceDefinition(
	val level: Int,
	val minQuality: Int,
	val maxQuality: Int,
	val minLevelRequired: Int,
	val maxLevelRequired: Int,
	val computedStats: Map<UInt, DestinyInventoryItemStatDefinition>,
	val sourceHashes: List<UInt>
)