package city.warlock.d2api.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyInventoryItemStatDefinition(
	val statHash: UInt,
	val value: Int,
	val minimum: Int,
	val maximum: Int,
	val displayMaximum: Int?
)