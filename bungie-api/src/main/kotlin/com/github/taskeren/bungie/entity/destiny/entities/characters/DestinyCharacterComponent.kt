package com.github.taskeren.bungie.entity.destiny.entities.characters

import com.github.taskeren.bungie.entity.destiny.DestinyProgression
import com.github.taskeren.bungie.entity.destiny.misc.DestinyColor
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
