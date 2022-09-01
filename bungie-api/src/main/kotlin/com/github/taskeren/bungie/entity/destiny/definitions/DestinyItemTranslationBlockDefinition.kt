package com.github.taskeren.bungie.entity.destiny.definitions

import com.github.taskeren.bungie.entity.destiny.DyeReference
import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemTranslationBlockDefinition(
	val weaponPatternIdentifier: String?,
	val weaponPatternHash: UInt,
	val defaultDyes: List<DyeReference>,
	val lockedDyes: List<DyeReference>,
	val customDyes: List<DyeReference>,
	val arrangements: List<DestinyGearArtArrangementReference>,
	val hasGeometry: Boolean
)
