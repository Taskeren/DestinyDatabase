package com.github.taskeren.bungie.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemMetricBlockDefinition(val availableMetricCategoryNodeHashes: List<UInt>)
