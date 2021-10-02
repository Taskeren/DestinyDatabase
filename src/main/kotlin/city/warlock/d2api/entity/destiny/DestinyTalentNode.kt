package city.warlock.d2api.entity.destiny

import city.warlock.d2api.entity.destiny.definitions.DestinyMaterialRequirement

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
