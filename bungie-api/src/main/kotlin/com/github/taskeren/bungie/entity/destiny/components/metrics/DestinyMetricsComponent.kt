package com.github.taskeren.bungie.entity.destiny.components.metrics

import kotlinx.serialization.Serializable

@Serializable
data class DestinyMetricsComponent(val metrics: Map<UInt, DestinyMetricComponent>, val metricsRootNodeHash: UInt)
