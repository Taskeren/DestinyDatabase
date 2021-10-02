package city.warlock.d2api.entity.destiny.definitions

import city.warlock.d2api.entity.destiny.definitions.common.DestinyDisplayPropertiesDefinition

data class DestinyDisplayCategoryDefinition(
	val index: Int,
	val identifier: String,
	val displayCategoryHash: UInt,
	val displayProperties: DestinyDisplayPropertiesDefinition,
	val displayInBanner: Boolean,
	val progressionHash: UInt?,
	val sortOrder: Int,
	val displayStyleHash: UInt?,
	val displayStyleIdentifier: String
)