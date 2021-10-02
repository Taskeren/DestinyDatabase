package city.warlock.d2api.entity.destiny

import kotlinx.serialization.Serializable

@Serializable
data class DyeReference(val channelHash: UInt, val dyeHash: UInt)
