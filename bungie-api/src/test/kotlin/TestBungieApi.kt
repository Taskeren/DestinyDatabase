import com.github.taskeren.bungie.BungieApi
import com.github.taskeren.bungie.compat.BungieLanguage
import com.github.taskeren.bungie.compat.EntityType
import com.github.taskeren.bungie.entity.MembershipType
import com.github.taskeren.bungie.entity.destiny.DestinyComponentType
import org.junit.jupiter.api.Test

class TestBungieApi {

	init {
		BungieApi.xApiKey = "734738f107484a19851235fbe8f8af90"

		// 使用系统代理
		System.setProperty("java.net.useSystemProxies", "true")

		// 启用 debugMode
		BungieApi.debugMode = true
	}

	@Test
	fun testGetManifest() {
		val mani = BungieApi.Destiny2.getDestinyManifest()

		val chUrl = mani.getJsonWorldComponentContentPaths(
			BungieLanguage.Chinese,
			EntityType.DestinyInventoryItemLiteDefinition
		)

		spark("GetManifest<TEST>", mani, chUrl)
	}

	@Test
	fun testSearchPlayer() {
		val playerList = BungieApi.Destiny2.searchDestinyPlayer(
			MembershipType.All,
			"Taskeren-3#5322"
		)

		spark("SearchPlayer<TEST>", playerList.map { it.displayName }, playerList, playerList.map { it.getTrackerNetworkUrl() })
	}

	@Test
	fun testGetProfileProfiles() {
		val data = BungieApi.Destiny2.getProfile(
			MembershipType.TigerSteam,
			4611686018500727480,
			listOf(DestinyComponentType.Profiles)
		)
		spark("GetProfileProfiles<TEST>", data)
	}

	@Test
	fun testGetProfileCollectibles() {
		val data = BungieApi.Destiny2.getProfile(
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
