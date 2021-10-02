package city.warlock.d2api.entity.destiny.definitions

import city.warlock.d2api.entity.destiny.DyeReference
import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemTranslationBlockDefinition(
	val weaponPatternIdentifier: String?,
	val weaponPatternHash: UInt,
	val defaultDyes: List<DyeReference>,
	val lockedDyes: List<DyeReference>,
	val customDyes: List<DyeReference>,
	val arrangements: List<DestinyGearArtArrangementReference>,
	val hasGeometry: Boolean
)
