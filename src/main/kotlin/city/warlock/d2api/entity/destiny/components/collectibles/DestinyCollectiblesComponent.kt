package city.warlock.d2api.entity.destiny.components.collectibles

data class DestinyCollectiblesComponent(
	val collectibles: Map<UInt, DestinyCollectibleComponent>,
	val collectionCategoriesRootNodeHash: UInt,
	val collectionBadgesRootNodeHash: UInt
)
