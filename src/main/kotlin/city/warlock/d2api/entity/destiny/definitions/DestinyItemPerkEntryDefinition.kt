package city.warlock.d2api.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemPerkEntryDefinition(
	val requirementDisplayString: String,
	val perkHash: UInt,
	val perkVisibility: Int
)