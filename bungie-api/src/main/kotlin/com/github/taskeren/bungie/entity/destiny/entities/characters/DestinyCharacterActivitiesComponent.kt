package com.github.taskeren.bungie.entity.destiny.entities.characters

import com.github.taskeren.bungie.entity.destiny.DestinyActivity
import com.github.taskeren.bungie.entity.destiny.milestones.DestinyModeTypeEnum
import com.github.taskeren.bungie.entity.destiny.milestones.toDestinyModeType
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.OffsetDateTime

@Serializable
data class DestinyCharacterActivitiesComponent(
	@Contextual
	val dateActivityStarted: OffsetDateTime,
	val availableActivities: List<DestinyActivity>,
	val currentActivityHash: UInt,
	val currentActivityModeHash: UInt,
	val currentActivityModeType: Int?,
	val currentActivityModeHashes: List<UInt>,
	val currentActivityModeTypes: List<Int>,
	val currentPlaylistActivityHash: UInt?,
	val lastCompletedStoryHash: UInt
) {
	fun enumCurrentActivityModeType(): DestinyModeTypeEnum? = currentActivityModeType?.toDestinyModeType()
	fun enumCurrentActivityModeTypes(): List<DestinyModeTypeEnum?> =
		currentActivityModeTypes.map { it.toDestinyModeType() }
}
