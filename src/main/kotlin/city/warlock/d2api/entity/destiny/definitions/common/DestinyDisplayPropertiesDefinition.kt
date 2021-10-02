package city.warlock.d2api.entity.destiny.definitions.common

import kotlinx.serialization.Serializable

@Serializable
data class DestinyDisplayPropertiesDefinition(
	val description: String,
	val name: String,
	val icon: String?,
	val iconSequences: List<DestinyIconSequenceDefinition>?,
	val highResIcon: String?,
	val hasIcon: Boolean
)
