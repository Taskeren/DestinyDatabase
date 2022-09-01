package com.github.taskeren.bungie.entity.destiny.components.records

data class DestinyCharacterRecordsComponent(
	val featuredRecordHashes: List<UInt>,
	val records: Map<UInt, DestinyRecordComponent>,
	val recordCategoriesRootNodeHash: UInt,
	val recordSealsRootNodeHash: UInt
)
