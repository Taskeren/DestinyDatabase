package com.github.taskeren.bungie.entity.destiny.definitions

import com.github.taskeren.bungie.entity.destiny.definitions.common.DestinyDisplayPropertiesDefinition

data class DestinyVendorInteractionDefinition(
	val interactionIndex: Int,
	val replies: List<DestinyVendorInteractionReplyDefinition>,
	val vendorCategoryIndex: Int,
	val questlineItemHash: UInt,
	val sackInteractionList: List<DestinyVendorInteractionSackEntryDefinition>,
	val uiInteractionType: UInt,
	val interactionType: Int,
	val rewardBlockLabel: String,
	val rewardVendorCategoryIndex: Int,
	val flavorLineOne: String,
	val flavorLineTwo: String,
	val headerDisplayProperties: DestinyDisplayPropertiesDefinition,
	val instructions: String
)
