package com.github.taskeren.bungie.entity.destiny.config

import com.github.taskeren.bungie.compat.BungieLanguage
import com.github.taskeren.bungie.compat.EntityType
import kotlinx.serialization.Serializable

@Serializable
data class DestinyManifest(
	val version: String,
	val mobileAssetContentPath: String,
	val mobileGearAssetDataBases: List<GearAssetDataBaseDefinition>,
	val mobileWorldContentPaths: Map<String, String>,
	val jsonWorldContentPaths: Map<String, String>,
	val jsonWorldComponentContentPaths: Map<String, Map<String, String>>,
	val mobileClanBannerDatabasePath: String,
	val mobileGearCDN: Map<String, String>,
	val iconImagePyramidInfo: List<ImagePyramidEntry>
) {

	fun getMobileWorldContentPath(code: BungieLanguage) = mobileWorldContentPaths[code.code]
	fun getJsonWorldContentPath(code: BungieLanguage) = jsonWorldContentPaths[code.code]
	fun getJsonWorldComponentContentPaths(code: BungieLanguage) = jsonWorldComponentContentPaths[code.code]
	fun getJsonWorldComponentContentPaths(code: BungieLanguage, definition: EntityType) =
		getJsonWorldComponentContentPaths(code)?.get(definition.name)

}