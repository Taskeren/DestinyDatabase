package com.github.taskeren.bungie.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemSackBlockDefinition(
	val detailAction: String,
	val openAction: String,
	val selectItemCount: Int,
	val vendorSackType: String?,
	val openOnAcquire: Boolean
)
