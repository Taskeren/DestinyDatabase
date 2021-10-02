package city.warlock.d2api.entity.destiny.entities.items

import city.warlock.d2api.entity.destiny.DestinyProgression
import city.warlock.d2api.entity.destiny.DestinyTalentNode

data class DestinyItemTalentGridComponent(
	val talentGridHash: UInt,
	val nodes: List<DestinyTalentNode>,
	val isGridComplete: Boolean,
	val gridProgression: DestinyProgression
)
