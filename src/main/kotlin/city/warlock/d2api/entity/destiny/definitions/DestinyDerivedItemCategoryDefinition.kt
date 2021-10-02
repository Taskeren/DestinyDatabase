package city.warlock.d2api.entity.destiny.definitions

import city.warlock.d2api.entity.destiny.definitions.items.DestinyDerivedItemDefinition
import kotlinx.serialization.Serializable

@Serializable
data class DestinyDerivedItemCategoryDefinition(
	val categoryDescription: String,
	val items: List<DestinyDerivedItemDefinition>
)
