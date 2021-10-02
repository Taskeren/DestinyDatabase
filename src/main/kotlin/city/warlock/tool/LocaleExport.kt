package city.warlock.tool

import city.warlock.*
import city.warlock.d2api.*
import city.warlock.d2api.compat.EntityType
import city.warlock.d2api.compat.BungieLanguage
import com.google.gson.*
import org.apache.logging.log4j.LogManager
import java.io.File

/**
 * 用于获取棒鸡汉化的工具类
 *
 * @see BungieApi.Destiny2.getDestinyManifest
 * @see city.warlock.destinyDB.init.updateDatabase
 */
object LocaleExport {

	private val logger = LogManager.getLogger("LocaleExport")

	fun exportLocale(translateMap: Map<String, String>, exportTo: File) {
		val json = JsonObject()
		translateMap.forEach { (id, name) -> json.addProperty(name, id) }
		exportTo.let {
			if(!it.exists()) {
				it.parentFile.mkdirs()
				it.createNewFile()
			}
			it.writeText(GsonBuilder().setPrettyPrinting().create().toJson(json))
		}
	}

	fun exportLocale(bungieLanguage: BungieLanguage, exportTo: File, xApiKey: String? = null) {
		if(xApiKey != null) {
			BungieApi.xApiKey = xApiKey
		} else if(BungieApi.xApiKey.isEmpty()) {
			logger.error("未设置棒鸡ApiKey！")
			return;
		}

		val translateMap = mutableMapOf<String, String>()

		logger.info("正在获取命运2Manifest")
		BungieApi.Destiny2.getDestinyManifest().getJsonWorldComponentContentPaths(
			bungieLanguage,
			EntityType.DestinyInventoryItemLiteDefinition
		).letNotNull {
			logger.info("获取到译名数据位置 ${it.toBungieResourceUrl()}")
			logger.info("开始下载译名数据")
			val contents = BungieApi.Helpers.getBungieResource(it).getJson().asJsonObject
			logger.info("译名数据下载完成")
			logger.info("开始读取译名数据")
			for(item in contents.entrySet()) {
				val id = item.key
				val name = item.value.ifObject { jsObj ->
					jsObj.sub("displayProperties").pri("name")?.asString
				} ?: run {
					logger.warn("无法读取物品 $id 的译名")
					"[@错误：无法获取物品名称@]"
				}

				translateMap[id] = name
				logger.trace("为 $id 添加译名 $name")
			}
			logger.info("译名数据读取完成")
		}

		logger.info("开始写入文件")
		exportLocale(translateMap, exportTo)
		logger.info("写入完成！")
	}

	fun exportLocale(cacheFile: File, exportTo: File) {
		val translateMap = mutableMapOf<String, String>()

		logger.info("开始下载译名数据")
		val contents = JsonParser.parseString(cacheFile.readText()).asJsonObject
		logger.info("译名数据下载完成")
		logger.info("开始读取译名数据")
		for(item in contents.entrySet()) {
			val id = item.key
			val name = item.value.ifObject { jsObj ->
				jsObj.sub("displayProperties").pri("name")?.asString
			} ?: run {
				logger.warn("无法读取物品 $id 的译名")
				"[@错误：无法获取物品名称@]"
			}

			translateMap[id] = name
			logger.trace("为 $id 添加译名 $name")
		}
		logger.info("译名数据读取完成")

		logger.info("开始写入文件")
		exportLocale(translateMap, exportTo)
		logger.info("写入完成！")
	}

}