package com.github.taskeren.bungie.entity.destiny.components.presentation

import kotlinx.serialization.Serializable

@Serializable
data class DestinyPresentationNodesComponent(val nodes: Map<UInt, DestinyPresentationNodeComponent>)
