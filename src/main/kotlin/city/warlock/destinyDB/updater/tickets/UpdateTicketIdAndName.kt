package city.warlock.destinyDB.updater.tickets

import city.warlock.d2api.BungieApi
import city.warlock.d2api.compat.EntityType
import city.warlock.d2api.getJson
import city.warlock.destinyDB.doc.IdAndName
import city.warlock.destinyDB.updater.Language
import city.warlock.destinyDB.updater.DatabaseUpdater
import city.warlock.pri
import city.warlock.sub

@Deprecated("See ItemDefinition")
class UpdateTicketIdAndName(val lang: Language) : UpdateTicket {

	override fun execute(updater: DatabaseUpdater) {
		logger.info("正在更新 ${lang.getLocalizedName()} 语言翻译数据")
		val itemDefinitionUrl = updater.getDestinyManifest().getJsonWorldComponentContentPaths(
			lang.bungieLang, EntityType.DestinyInventoryItemLiteDefinition
		)!!

		logger.info("成功获取 ${lang.getLocalizedName()} 语言翻译数据，开始写入数据库")
		val itemDefinitions = BungieApi.Helpers.getBungieResource(itemDefinitionUrl).getJson().asJsonObject

		val co = updater.database.getTranslation(lang.bungieLang)
		co.drop()

		itemDefinitions.entrySet().forEach { (hashId, definition) ->
			co.insertOne(
				IdAndName(hashId,
					(definition.asJsonObject
						.sub("displayProperties")
						.pri("name")?.asString) ?: "#Unnamed $hashId#")
			)
		}

		logger.info("完成 ${lang.getLocalizedName()} 语言翻译数据")
	}
}