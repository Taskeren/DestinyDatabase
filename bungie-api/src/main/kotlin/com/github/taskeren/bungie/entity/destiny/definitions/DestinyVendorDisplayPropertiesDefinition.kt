package com.github.taskeren.bungie.entity.destiny.definitions

import com.github.taskeren.bungie.entity.destiny.definitions.common.DestinyIconSequenceDefinition

data class DestinyVendorDisplayPropertiesDefinition(
	val largeIcon: String,
	val subtitle: String,
	val originalIcon: String,
	val requirementsDisplay: List<DestinyVendorRequirementDisplayEntryDefinition>,
	val smallTransparentIcon: String,
	val mapIcon: String,
	val largeTransparentIcon: String,
	val description: String,
	val name: String,
	val icon: String,
	val iconSequence: DestinyIconSequenceDefinition,
	val highResIcon: String,
	val hasIcon: Boolean
)
