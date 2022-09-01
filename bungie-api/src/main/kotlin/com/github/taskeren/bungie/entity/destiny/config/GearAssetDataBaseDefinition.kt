package com.github.taskeren.bungie.entity.destiny.config

import kotlinx.serialization.Serializable

@Serializable
data class GearAssetDataBaseDefinition(
	val version: Int,
	val path: String
)
