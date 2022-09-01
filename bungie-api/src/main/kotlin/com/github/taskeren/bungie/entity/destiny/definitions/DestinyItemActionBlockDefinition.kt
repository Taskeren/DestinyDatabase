package com.github.taskeren.bungie.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemActionBlockDefinition(
	val verbName: String,
	val verbDescription: String,
	val isPositive: Boolean,
	val overlayScreenName: String?,
	val overlayIcon: String?,
	val requiredCooldownSeconds: Int,
	val requiredItems: List<DestinyItemActionRequiredItemDefinition>,
	val progressionRewards: List<DestinyProgressionRewardDefinition>,
	val actionTypeLabel: String?,
	val requiredLocation: String?,
	val requiredCooldownHash: UInt,
	val deleteOnAction: Boolean,
	val consumeEntireStack: Boolean,
	val useOnAcquire: Boolean
)
