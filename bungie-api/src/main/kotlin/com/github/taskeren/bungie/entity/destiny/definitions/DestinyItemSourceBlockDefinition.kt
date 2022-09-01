package com.github.taskeren.bungie.entity.destiny.definitions

import com.github.taskeren.bungie.entity.destiny.definitions.sources.DestinyItemSourceDefinition
import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemSourceBlockDefinition(
	val sourceHashes: List<UInt>,
	val sources: List<DestinyItemSourceDefinition>,
	val exclusive: Int,
	val vendorSources: DestinyItemVendorSourceReference
)
