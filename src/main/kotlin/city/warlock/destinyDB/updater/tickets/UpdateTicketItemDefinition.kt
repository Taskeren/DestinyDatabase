package city.warlock.destinyDB.updater.tickets

import city.warlock.d2api.*
import city.warlock.d2api.compat.EntityType
import city.warlock.d2api.entity.destiny.definitions.DestinyInventoryItemDefinition
import city.warlock.destinyDB.updater.Language
import city.warlock.destinyDB.updater.DatabaseUpdater
import kotlinx.serialization.json.*
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class UpdateTicketItemDefinition(vararg val lang: Language) : UpdateTicket {

	override fun execute(updater: DatabaseUpdater) {
		lang.forEach { lang ->
			logger.info("正在更新 ${lang.getLocalizedName()} 的物品定义数据")
			// 获取数据
			val itemDefinitionUrl = updater.getDestinyManifest()
				.getJsonWorldComponentContentPaths(lang.bungieLang, EntityType.DestinyInventoryItemDefinition)!!
			val itemDefinitions = BungieApi.Helpers.getBungieResource(itemDefinitionUrl).getKtJson()

			logger.info("成功获取 ${lang.getLocalizedName()} 的物品定义数据，开始写入数据库")
			// 连接数据库
			val co = updater.database.getItemDefinition(lang.bungieLang)
			co.drop()

			// 加入数据库
			val listDef = itemDefinitions.jsonObject.values.map { ktJson.decodeFromJsonElement<DestinyInventoryItemDefinition>(it) }
			co.insertMany(listDef)
			logger.info("完成 ${lang.getLocalizedName()} 的物品定义数据更新！")
		}
	}
}