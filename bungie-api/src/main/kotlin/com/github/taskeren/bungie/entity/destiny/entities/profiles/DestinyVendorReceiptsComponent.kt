package com.github.taskeren.bungie.entity.destiny.entities.profiles

import com.github.taskeren.bungie.entity.destiny.vendors.DestinyVendorReceipt
import kotlinx.serialization.Serializable

@Serializable
data class DestinyVendorReceiptsComponent(val receipts: List<DestinyVendorReceipt>)
