package com.github.taskeren.bungie.db.updater.tickets

import com.github.taskeren.bungie.BungieApi
import com.github.taskeren.bungie.compat.EntityType
import com.github.taskeren.bungie.db.updater.DatabaseUpdater
import com.github.taskeren.bungie.db.updater.Language
import com.github.taskeren.bungie.entity.destiny.definitions.DestinyInventoryItemDefinition
import com.github.taskeren.bungie.getKtJson
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.jsonObject

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