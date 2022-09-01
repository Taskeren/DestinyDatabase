package com.github.taskeren.bungie.entity.destiny.components.metrics

data class DestinyMetricsComponent(val metrics: Map<UInt, DestinyMetricComponent>, val metricsRootNodeHash: UInt)
