package city.warlock.d2api.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyProgressionRewardDefinition(val progressionMappingHash: UInt, val amount: Int, val applyThrottles: Boolean)
