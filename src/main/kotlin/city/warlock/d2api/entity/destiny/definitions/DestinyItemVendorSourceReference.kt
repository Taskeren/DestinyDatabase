package city.warlock.d2api.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemVendorSourceReference(val vendorHash: UInt, val vendorItemIndexes: List<Int>)
