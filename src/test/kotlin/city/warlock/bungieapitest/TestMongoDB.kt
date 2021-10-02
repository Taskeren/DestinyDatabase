package city.warlock.bungieapitest

import city.warlock.d2api.*
import city.warlock.d2api.compat.BungieLanguage
import city.warlock.d2api.compat.EntityType
import city.warlock.d2api.entity.destiny.definitions.DestinyInventoryItemDefinition
import city.warlock.destinyDB.*
import city.warlock.destinyDB.updater.Language
import city.warlock.tool.LocaleExport
import com.mongodb.assertions.Assertions
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.*
import org.junit.jupiter.api.Test
import java.io.File

class TestMongoDB {

	init {
		BungieApi.xApiKey = "734738f107484a19851235fbe8f8af90"

		// 使用系统代理
		System.setProperty("java.net.useSystemProxies", "true")
	}

	val db = DestinyDatabase()

	@Test
	fun testUpdateItemDefinitions() {
		db.createUpdater().updateItemDefinitions(*Language.values())
		testItemDefinitionValidate()
	}

	@OptIn(ExperimentalSerializationApi::class)
	private val json = Json {
		ignoreUnknownKeys = true
		explicitNulls = false
	}

	/**
	 * 下载下面要用的 ItemDefinition
	 */
	@Test
	fun testDownloadLatestItemDefinitionToLocalFile() {
		val itemDefinitionUrl = BungieApi.Destiny2.getDestinyManifest()
			.getJsonWorldComponentContentPaths(BungieLanguage.Chinese, EntityType.DestinyInventoryItemDefinition)!!
		val content = BungieApi.Helpers.getBungieResource(itemDefinitionUrl).getString()
		File("./temp/itemDefinition.json").let {
			it.createNewFile()
			it.writeText(content)
		}
	}

	/**
	 * 根据本地的 ItemDefinition 来解析一下看看有没有问题
	 * 从上面那个 test 里下载
	 */
	@Test
	fun testUpdateItemDefinitionsByLocalFile() {
		Json.parseToJsonElement(File("./temp/itemDefinition.json").readText()).let { root ->
			root.jsonObject.values.map {
				json.decodeFromJsonElement<DestinyInventoryItemDefinition>(it)
			}
		}.forEach {
			println(it)
		}
	}

	@Test
	fun testItemDefinitionValidate() {
		val dmtChs = db.getItemDefinition(BungieLanguage.ChineseSimplified).findByName("亡者传说").last()

		Assertions.assertNotNull(dmtChs)
		println("Chinese DMT Definition")
		println(dmtChs)

		val dmtHash = dmtChs.hash!!
		println("Hash: $dmtHash(${dmtHash.toInt()})")
		val dmtEng = db.getItemDefinition(BungieLanguage.English).findByHash(dmtHash)

		Assertions.assertNotNull(dmtEng)
		println("English DMT Definition")
		println(dmtEng)

		println("light.gg at ${BungieApi.Helpers.getLightGGUrl(dmtHash)}")
	}

	@Test
	fun testExportLocale() {
		LocaleExport.exportLocale(BungieLanguage.Chinese, File("./localization_cht.json"))
		LocaleExport.exportLocale(BungieLanguage.ChineseSimplified, File("./localization_chs.json"))
	}

}