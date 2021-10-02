package city.warlock.d2api.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemInvestmentStatDefinition(
	val statTypeHash: UInt,
	val value: Int,
	val isConditionallyActive: Boolean
)
