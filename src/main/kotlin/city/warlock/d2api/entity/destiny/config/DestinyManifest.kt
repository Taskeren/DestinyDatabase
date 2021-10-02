package city.warlock.d2api.entity.destiny.config

import city.warlock.d2api.compat.EntityType
import city.warlock.d2api.compat.BungieLanguage

data class DestinyManifest(
	val version: String,
	val mobileAssetContentPath: String,
	val mobileGearAssetDataBases: List<Any>, // TODO: Destiny.Config.GearAssetDataBaseDefinition
	val mobileWorldContentPaths: Map<String, String>,
	val jsonWorldContentPaths: Map<String, String>,
	val jsonWorldComponentContentPaths: Map<String, Map<String, String>>,
	val mobileClanBannerDatabasePath: String,
	val mobileGearCDN: Map<String, String>,
	val iconImagePyramidInfo: List<Any> // TODO: Destiny.Config.ImagePyramidEntry
) {

	fun getMobileWorldContentPath(code: BungieLanguage) = mobileWorldContentPaths[code.code]
	fun getJsonWorldContentPath(code: BungieLanguage) = jsonWorldContentPaths[code.code]
	fun getJsonWorldComponentContentPaths(code: BungieLanguage) = jsonWorldComponentContentPaths[code.code]
	fun getJsonWorldComponentContentPaths(code: BungieLanguage, definition: EntityType) =
		getJsonWorldComponentContentPaths(code)?.get(definition.name)

}