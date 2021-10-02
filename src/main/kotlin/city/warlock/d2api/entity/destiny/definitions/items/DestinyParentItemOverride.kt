package city.warlock.d2api.entity.destiny.definitions.items

import kotlinx.serialization.Serializable

@Serializable
data class DestinyParentItemOverride(val additionalEquipRequirementsDisplayStrings: List<String>, val pipIcon: String)
