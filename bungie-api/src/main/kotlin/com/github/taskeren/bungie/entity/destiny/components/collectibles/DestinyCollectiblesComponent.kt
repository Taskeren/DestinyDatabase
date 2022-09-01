package com.github.taskeren.bungie.entity.destiny.components.collectibles

data class DestinyCollectiblesComponent(
	val collectibles: Map<UInt, DestinyCollectibleComponent>,
	val collectionCategoriesRootNodeHash: UInt,
	val collectionBadgesRootNodeHash: UInt
)
