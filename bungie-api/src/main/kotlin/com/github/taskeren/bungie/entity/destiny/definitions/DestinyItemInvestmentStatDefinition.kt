package com.github.taskeren.bungie.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemInvestmentStatDefinition(
	val statTypeHash: UInt,
	val value: Int,
	val isConditionallyActive: Boolean
)
