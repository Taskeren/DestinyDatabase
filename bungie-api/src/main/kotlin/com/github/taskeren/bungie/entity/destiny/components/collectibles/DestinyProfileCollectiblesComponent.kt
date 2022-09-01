package com.github.taskeren.bungie.entity.destiny.components.collectibles

import kotlinx.serialization.Serializable

@Serializable
data class DestinyProfileCollectiblesComponent(
	val recentCollectibleHashes: List<UInt>,
	val newnessFlaggedCollectibleHashes: List<UInt>? = null,
	val collectibles: Map<UInt, DestinyCollectibleComponent>,
	val collectionCategoriesRootNodeHash: UInt,
	val collectionBadgesRootNodeHash: UInt
)
