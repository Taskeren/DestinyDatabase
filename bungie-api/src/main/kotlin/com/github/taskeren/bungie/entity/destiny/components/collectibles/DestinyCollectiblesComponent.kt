package com.github.taskeren.bungie.entity.destiny.components.collectibles

import kotlinx.serialization.Serializable

@Serializable
data class DestinyCollectiblesComponent(
	val collectibles: Map<UInt, DestinyCollectibleComponent>,
	val collectionCategoriesRootNodeHash: UInt,
	val collectionBadgesRootNodeHash: UInt
)
