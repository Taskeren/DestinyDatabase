package com.github.taskeren.bungie.entity.destiny.character

import kotlinx.serialization.Serializable

@Serializable
data class DestinyCharacterPeerView(val equipment: List<DestinyItemPeerView>)
