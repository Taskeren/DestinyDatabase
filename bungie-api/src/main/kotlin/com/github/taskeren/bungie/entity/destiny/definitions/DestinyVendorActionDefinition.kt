package com.github.taskeren.bungie.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyVendorActionDefinition(
	val description: String,
	val executeSeconds: Int,
	val icon: String,
	val name: String,
	val verb: String,
	val isPositive: Boolean,
	val actionId: Int,
	val actionHash: UInt,
	val autoPerformAction: Boolean
)
