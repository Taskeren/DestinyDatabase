package com.github.taskeren.bungie.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyVendorRequirementDisplayEntryDefinition(val icon: String, val name: String, val source: String, val type: String)
