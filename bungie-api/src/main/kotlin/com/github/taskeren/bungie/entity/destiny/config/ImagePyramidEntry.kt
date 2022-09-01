package com.github.taskeren.bungie.entity.destiny.config

import kotlinx.serialization.Serializable

@Serializable
data class ImagePyramidEntry(
	val name: String,
	val factor: Float
)
