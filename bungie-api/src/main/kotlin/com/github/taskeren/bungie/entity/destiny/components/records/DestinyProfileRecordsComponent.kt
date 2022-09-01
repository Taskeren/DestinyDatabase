package com.github.taskeren.bungie.entity.destiny.components.records

import kotlinx.serialization.Serializable

@Serializable
data class DestinyProfileRecordsComponent(
	val score: Int,
	val activeScore: Int,
	val legacyScore: Int,
	val lifetimeScore: Int,
	val trackedRecordHash: UInt?,
	val records: Map<UInt, DestinyRecordComponent>,
	val recordCategoriesRootNodeHash: UInt,
	val recordSealsRootNodeHash: UInt
)
