package com.github.taskeren.bungie.entity.destiny

import com.github.taskeren.bungie.entity.destiny.definitions.DestinyMaterialRequirement
import kotlinx.serialization.Serializable

@Serializable
data class DestinyTalentNode(
	val nodeIndex: Int,
	val nodeHash: UInt,
	val state: Int,
	val isActivated: Boolean,
	val stepIndex: Int,
	val materialsToUpgrade: List<DestinyMaterialRequirement>,
	val activationGridLevel: Int,
	val progressPercent: Float,
	val hidden: Boolean,
	val nodeStatsBlock: DestinyTalentNodeStatBlock
)
