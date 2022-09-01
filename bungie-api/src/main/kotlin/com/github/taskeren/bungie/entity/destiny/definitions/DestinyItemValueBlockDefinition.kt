package com.github.taskeren.bungie.entity.destiny.definitions

import com.github.taskeren.bungie.entity.destiny.DestinyItemQuantity
import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemValueBlockDefinition(val itemValue: List<DestinyItemQuantity>, val valueDescription: String)
