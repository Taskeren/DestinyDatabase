package com.github.taskeren.bungie.entity.destiny.components.collectibles

data class DestinyProfileCollectiblesComponent(
	val recentCollectibleHashes: List<UInt>,
	val newnessFlaggedCollectibleHashes: List<UInt>,
	val collectibles: Map<UInt, DestinyCollectibleComponent>,
	val collectionCategoriesRootNodeHash: UInt,
	val collectionBadgesRootNodeHash: UInt
)
