package com.github.taskeren.bungie.entity.destiny.components.inventory

import kotlinx.serialization.Serializable

@Serializable
data class DestinyCurrenciesComponent(val itemQuantities: Map<UInt, Int>)
