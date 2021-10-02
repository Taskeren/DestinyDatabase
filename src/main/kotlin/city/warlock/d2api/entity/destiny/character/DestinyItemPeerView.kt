package city.warlock.d2api.entity.destiny.character

import city.warlock.d2api.entity.destiny.DyeReference

data class DestinyItemPeerView(val itemHash: UInt, val dyes: List<DyeReference>)
