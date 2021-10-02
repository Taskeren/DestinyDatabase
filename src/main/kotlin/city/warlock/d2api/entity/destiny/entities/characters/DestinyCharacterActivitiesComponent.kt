package city.warlock.d2api.entity.destiny.entities.characters

import city.warlock.d2api.entity.destiny.DestinyActivity
import city.warlock.d2api.entity.destiny.milestones.DestinyModeTypeEnum
import city.warlock.d2api.entity.destiny.milestones.toDestinyModeType
import java.util.*

data class DestinyCharacterActivitiesComponent(
	val dateActivityStarted: Date,
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
	fun enumCurrentActivityModeTypes(): List<DestinyModeTypeEnum?> = currentActivityModeTypes.map { it.toDestinyModeType() }
}
