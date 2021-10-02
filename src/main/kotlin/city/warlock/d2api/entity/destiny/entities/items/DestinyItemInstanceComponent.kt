package city.warlock.d2api.entity.destiny.entities.items

import city.warlock.d2api.entity.destiny.DestinyStat

data class DestinyItemInstanceComponent(
	val damageType: Int,
	val damageTypeHash: UInt,
	val primaryStat: DestinyStat,
	val itemLevel: Int,
	val quality: Int,
	val isEquipped: Boolean,
	val canEquip: Boolean,
	val equipRequiredLevel: Int,
	val unlockHashesRequiredToEquip: List<UInt>,
	val cannotEquipReason: Int,
	val breakerType: Int?
)
