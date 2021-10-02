package city.warlock.d2api.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemInventoryBlockDefinition(
	val stackUniqueLabel: String?,
	val maxStackSize: Int,
	val bucketTypeHash: UInt,
	val recoveryBucketTypeHash: UInt,
	val tierTypeHash: UInt,
	val isInstanceItem: Boolean,
	val tierTypeName: String?,
	val tierType: Int,
	val expirationTooltip: String?,
	val expiredInActivityMessage: String?,
	val expiredInOrbitMessage: String?,
	val suppressExpirationWhenObjectivesComplete: Boolean
)
