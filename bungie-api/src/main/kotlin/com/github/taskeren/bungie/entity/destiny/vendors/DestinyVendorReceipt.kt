package com.github.taskeren.bungie.entity.destiny.vendors

import com.github.taskeren.bungie.entity.destiny.DestinyItemQuantity
import java.util.*

data class DestinyVendorReceipt(
	val currencyPaid: DestinyItemQuantity,
	val itemReceived: DestinyItemQuantity,
	val licenseUnlockHash: UInt,
	val purchasedByCharacterId: Long,
	val sequenceNumber: Int,
	val timeToExpiration: Int,
	val expiresOn: Date
)
