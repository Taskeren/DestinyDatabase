package city.warlock.d2api.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyAnimationReference(val animName: String, val animIdentifier: String, val path: String)
