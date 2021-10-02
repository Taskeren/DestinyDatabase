package city.warlock.d2api.entity.destiny.entities.characters

import city.warlock.d2api.entity.destiny.DestinyProgression
import city.warlock.d2api.entity.destiny.misc.DestinyColor
import java.util.*

data class DestinyCharacterComponent(
	val membershipId: Long,
	val membershipType: Int,
	val characterId: Long,
	val dateLastPlayed: Date,
	val minutesPlayedThisSession: Long,
	val minutesPlayedTotal: Int,
	val light: Int,
	val stats: Map<UInt, Int>,
	val raceHash: UInt,
	val genderHash: UInt,
	val classHash: UInt,
	val raceType: Int,
	val classType: Int,
	val genderType: Int,
	val emblemPath: String,
	val emblemBackgroundPath: String,
	val emblemHash: UInt,
	val emblemColor: DestinyColor,
	val levelProgression: DestinyProgression,
	val baseCharacterLevel: Int,
	val percentToNextLevel: Float,
	val titleRecordHash: UInt?
)
