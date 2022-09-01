package com.github.taskeren.bungie.entity.destiny.entities.items

import com.github.taskeren.bungie.entity.Placeholder
import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemPlugObjectivesComponent(val objectivesPerPlug: Map<UInt, List<Placeholder>>) // TODO: Solve the problem that what is Any
