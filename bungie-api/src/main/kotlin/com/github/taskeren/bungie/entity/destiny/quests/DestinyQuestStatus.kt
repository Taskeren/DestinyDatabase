package com.github.taskeren.bungie.entity.destiny.quests

import kotlinx.serialization.Serializable

@Serializable
data class DestinyQuestStatus(
	val questHash: UInt,
	val stepHash: UInt,
	val stepObjectives: List<DestinyObjectiveProgress>,
	val tracked: Boolean,
	val itemInstanceId: Long,
	val completed: Boolean,
	val redeemed: Boolean,
	val started: Boolean,
	val vendorHash: UInt?
)
