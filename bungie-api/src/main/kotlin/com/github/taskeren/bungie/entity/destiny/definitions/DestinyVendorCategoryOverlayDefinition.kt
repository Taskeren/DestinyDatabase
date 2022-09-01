package com.github.taskeren.bungie.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyVendorCategoryOverlayDefinition(val choiceDescription: String, val description: String, val icon: String, val title: String, val currencyItemHash: UInt?)
