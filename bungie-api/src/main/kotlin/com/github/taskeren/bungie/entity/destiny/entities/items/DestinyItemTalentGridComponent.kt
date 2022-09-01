package com.github.taskeren.bungie.entity.destiny.entities.items

import com.github.taskeren.bungie.entity.destiny.DestinyProgression
import com.github.taskeren.bungie.entity.destiny.DestinyTalentNode

data class DestinyItemTalentGridComponent(
	val talentGridHash: UInt,
	val nodes: List<DestinyTalentNode>,
	val isGridComplete: Boolean,
	val gridProgression: DestinyProgression
)
