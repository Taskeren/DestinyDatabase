package city.warlock.d2api.entity.destiny.definitions

import city.warlock.d2api.entity.destiny.DestinyItemQuantity
import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemValueBlockDefinition(val itemValue: List<DestinyItemQuantity>, val valueDescription: String)
