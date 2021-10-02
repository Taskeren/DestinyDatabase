package city.warlock.d2api.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemIntrinsicSocketEntryDefinition(
	val plugItemHash: UInt,
	val socketTypeHash: UInt,
	val defaultVisible: Boolean
)