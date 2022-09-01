package com.github.taskeren.bungie.entity.destiny.definitions

import com.github.taskeren.bungie.entity.destiny.definitions.items.DestinyDerivedItemDefinition
import kotlinx.serialization.Serializable

@Serializable
data class DestinyDerivedItemCategoryDefinition(
	val categoryDescription: String,
	val items: List<DestinyDerivedItemDefinition>
)
