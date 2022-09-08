import com.github.taskeren.bungie.BungieApi
import com.github.taskeren.bungie.compat.BungieLanguage
import com.github.taskeren.bungie.compat.EntityType
import com.github.taskeren.bungie.entity.MembershipType
import com.github.taskeren.bungie.entity.destiny.DestinyComponentType
import com.moandjiezana.toml.Toml
import org.junit.jupiter.api.Test
import java.io.File

class TestBungieApi {

	val config: Toml

	init {
		// 使用系统代理
		System.setProperty("java.net.useSystemProxies", "true")

		// 加载数据
		val configFile = File("test.toml")
		config = Toml().read(configFile)
	}

	val clientId = config.getLong("client_id").toString()
	val clientSecret = config.getString("client_secret")

	val bungieApi = BungieApi("734738f107484a19851235fbe8f8af90")

	@Test
	fun `test authorize`() {
		val resp = bungieApi.authorize.getAuthorizeUrl(clientId)

		spark("GetAuthorizeUrl<TEST>", resp)
	}

	@Test
	fun `test get token`() {
		val code = config.getString("code")?.toString() ?: throw IllegalArgumentException("Argument 'code' is unset.")

		val token = bungieApi.authorize.getToken(code, clientId, clientSecret)

		spark("GetToken<TEST>", token)
	}

	@Test
	fun testGetManifest() {
		val mani = bungieApi.destiny2.getDestinyManifest()

		val chUrl = mani.getJsonWorldComponentContentPaths(
			BungieLanguage.Chinese,
			EntityType.DestinyInventoryItemLiteDefinition
		)

		spark("GetManifest<TEST>", mani, chUrl)
	}

	@Test
	fun testSearchPlayer() {
		val playerList = bungieApi.destiny2.searchDestinyPlayer(
			MembershipType.All,
			"Taskeren-3#5322"
		)

		spark("SearchPlayer<TEST>", playerList.map { it.displayName }, playerList, playerList.map { it.getTrackerNetworkUrl() })
	}

	@Test
	fun testGetProfileProfiles() {
		val data = bungieApi.destiny2.getProfile(
			MembershipType.TigerSteam,
			4611686018500727480,
			listOf(DestinyComponentType.Profiles)
		)
		spark("GetProfileProfiles<TEST>", data)
	}

	@Test
	fun testGetProfileCollectibles() {
		val data = bungieApi.destiny2.getProfile(
			MembershipType.TigerSteam,
			4611686018500727480,
			listOf(DestinyComponentType.Collectibles)
		)
		spark("GetProfileCollectibles<TEST>", data)
	}

}

private fun String.prettyPrintDataClass(indentStr: String = "\t") {
	var indent = 0

	forEach {
		when(it) {
			'(' -> {
				indent++
				println(it) // new line
				print(List(indent) { indentStr }.joinToString(separator = ""))
			}
			')' -> {
				indent--
				println()
				print(List(indent) { indentStr }.joinToString(separator = ""))
				print(it)
			}
			',' -> {
				println(",")
				print(List(indent) { indentStr }.joinToString(separator = ""))
			}
			'[' -> {
				indent++
				println(it) // new line
				print(List(indent) { indentStr }.joinToString(separator = ""))
			}
			']' -> {
				indent--
				println()
				print(List(indent) { indentStr }.joinToString(separator = ""))
				print(it)
			}
			' ' -> {}
			else -> print(it)
		}
	}

	println()
}

private fun spark(contentTitle: String, vararg printThings: Any?) {
	when(printThings.size) {
		0 -> {
			println("=====[ $contentTitle ]=====")
			println("[EMPTY CONTENT]")
		}
		1 -> {
			println("=====[ $contentTitle ]=====")
			val singleton = printThings[0]
			if(singleton != null && singleton::class.isData) {
				singleton.toString().prettyPrintDataClass()
			} else {
				println(singleton)
			}
		}
		else -> {
			printThings.forEachIndexed { index, content ->
				println("=====[ (${index+1}/${printThings.size}) $contentTitle ]=====")
				if(content != null && content::class.isData) {
					content.toString().prettyPrintDataClass()
				} else {
					println(content)
				}
			}
		}
	}
}
