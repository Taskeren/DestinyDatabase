package com.github.taskeren.bungie.entity.destiny.entities.items

import com.github.taskeren.bungie.entity.destiny.quests.DestinyObjectiveProgress
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.OffsetDateTime

@Serializable
data class DestinyItemComponent(
	val itemHash: UInt,
	val itemInstanceId: Long?,
	val quantity: Int,
	val bindStatus: Int,
	val location: Int,
	val bucketHash: UInt,
	val transferStatus: Int,
	val lockable: Boolean,
	val state: Int,
	val overrideStyleItemHash: UInt,
	@Contextual
	val expirationDate: OffsetDateTime?,
	val isWrapper: Boolean,
	val tooltipNotificationIndexes: List<Int>,
	val metricObjective: DestinyObjectiveProgress,
	val versionNumber: Int?,
	val itemValueVisibility: List<Boolean>
)
