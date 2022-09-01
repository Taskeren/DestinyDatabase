package com.github.taskeren.bungie.entity.destiny

import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemQuantity(
	val itemHash: UInt,
	val itemInstanceId: Long?,
	val quantity: Int,
	val hasConditionalVisibility: Boolean
)
