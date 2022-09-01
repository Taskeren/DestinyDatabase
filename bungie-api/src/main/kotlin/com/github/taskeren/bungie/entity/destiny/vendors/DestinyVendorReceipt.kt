package com.github.taskeren.bungie.entity.destiny.vendors

import com.github.taskeren.bungie.entity.destiny.DestinyItemQuantity
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.OffsetDateTime

@Serializable
data class DestinyVendorReceipt(
	val currencyPaid: DestinyItemQuantity,
	val itemReceived: DestinyItemQuantity,
	val licenseUnlockHash: UInt,
	val purchasedByCharacterId: Long,
	val sequenceNumber: Int,
	val timeToExpiration: Int,
	@Contextual
	val expiresOn: OffsetDateTime
)
