package com.github.taskeren.bungie.entity.destiny.entities.characters

import com.github.taskeren.bungie.entity.destiny.DyeReference
import com.github.taskeren.bungie.entity.destiny.character.DestinyCharacterCustomization
import com.github.taskeren.bungie.entity.destiny.character.DestinyCharacterPeerView
import kotlinx.serialization.Serializable

@Serializable
data class DestinyCharacterRenderComponent(
	val customDyes: DyeReference,
	val customization: DestinyCharacterCustomization,
	val peerView: DestinyCharacterPeerView
)
