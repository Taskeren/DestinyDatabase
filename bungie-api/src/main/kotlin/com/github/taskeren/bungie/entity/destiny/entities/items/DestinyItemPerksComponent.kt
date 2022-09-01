package com.github.taskeren.bungie.entity.destiny.entities.items

import com.github.taskeren.bungie.entity.destiny.perks.DestinyPerkReference
import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemPerksComponent(val perks: List<DestinyPerkReference>)
