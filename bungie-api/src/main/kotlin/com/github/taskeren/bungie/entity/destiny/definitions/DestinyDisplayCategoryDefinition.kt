package com.github.taskeren.bungie.entity.destiny.definitions

import com.github.taskeren.bungie.entity.destiny.definitions.common.DestinyDisplayPropertiesDefinition

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