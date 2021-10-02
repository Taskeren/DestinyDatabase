package city.warlock.d2api.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemTalentGridBlockDefinition(
	val talentGridHash: UInt,
	val itemDetailString: String,
	val buildName: String? = null,
	val hudDamageType: Int,
	val hudIcon: String? = null
)
