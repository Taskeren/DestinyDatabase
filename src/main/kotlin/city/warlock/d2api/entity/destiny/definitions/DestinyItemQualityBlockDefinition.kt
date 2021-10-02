package city.warlock.d2api.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemQualityBlockDefinition(
	val itemLevels: List<Int>,
	val qualityLevel: Int,
	val infusionCategoryName: String,
	val infusionCategoryHashes: List<UInt>,
	val progressionLevelRequirementHash: UInt,
	val currentVersion: UInt,
	val versions: List<DestinyItemVersionDefinition>,
	val displayVersionWatermarkIcons: List<String>
)
