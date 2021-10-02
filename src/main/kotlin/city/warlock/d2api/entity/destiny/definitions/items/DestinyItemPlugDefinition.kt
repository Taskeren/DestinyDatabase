package city.warlock.d2api.entity.destiny.definitions.items

import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemPlugDefinition(
	val insertionRules: List<DestinyPlugRuleDefinition>,
	val plugCategoryIdentifier: String,
	val plugCategoryHash: UInt,
	val onActionRecreateSelf: Boolean,
	val insertionMaterialRequirementHash: UInt,
	val previewItemOverrideHash: UInt,
	val enabledMaterialRequirementHash: UInt,
	val enabledRules: List<DestinyPlugRuleDefinition>,
	val uiPlugLabel: String,
	val plugStyle: Int,
	val alternateUiPlugLabel: String,
	val isDummyPlug: Boolean,
	val parentItemOverride: DestinyParentItemOverride?,
	val energyCapacity: DestinyEnergyCapacityEntry?,
	val energyCost: DestinyEnergyCostEntry?
)
