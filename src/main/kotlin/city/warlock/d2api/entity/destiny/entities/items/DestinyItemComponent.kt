package city.warlock.d2api.entity.destiny.entities.items

import city.warlock.d2api.entity.destiny.quests.DestinyObjectiveProgress
import java.util.*

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
	val expirationDate: Date?,
	val isWrapper: Boolean,
	val tooltipNotificationIndexes: List<Int>,
	val metricObjective: DestinyObjectiveProgress,
	val versionNumber: Int?,
	val itemValueVisibility: List<Boolean>
)
