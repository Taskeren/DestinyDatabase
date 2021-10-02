package city.warlock.d2api.entity.destiny.entities.characters

import city.warlock.d2api.entity.destiny.DyeReference
import city.warlock.d2api.entity.destiny.character.DestinyCharacterCustomization
import city.warlock.d2api.entity.destiny.character.DestinyCharacterPeerView

data class DestinyCharacterRenderComponent(
	val customDyes: DyeReference,
	val customization: DestinyCharacterCustomization,
	val peerView: DestinyCharacterPeerView
)
