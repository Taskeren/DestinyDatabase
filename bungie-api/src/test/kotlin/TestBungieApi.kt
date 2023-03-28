import com.github.taskeren.bungie.BungieApi
import com.github.taskeren.bungie.compat.BungieLanguage
import com.github.taskeren.bungie.compat.EntityType
import com.github.taskeren.bungie.entity.MembershipType
import com.github.taskeren.bungie.entity.destiny.DestinyComponentType
import kotlinx.coroutines.runBlocking

/**
 * Bungie API 测试例
 *
 * 使用 TestMain 启动测试！
 */
class TestBungieApi {

	lateinit var bungieApi: BungieApi

	@TestByNova
	fun testGetManifest() = runBlocking {
		val mani = bungieApi.destiny2.getDestinyManifest().data

		val chUrl = mani.getJsonWorldComponentContentPaths(
			BungieLanguage.Chinese,
			EntityType.DestinyInventoryItemLiteDefinition
		)

		spark("GetManifest<TEST>", mani, chUrl)
	}

	@TestByNova
	fun testSearchPlayer() = runBlocking {
		val playerList = bungieApi.destiny2.searchDestinyPlayer(
			MembershipType.All,
			"Taskeren-3#5322"
		).data

		spark("SearchPlayer<TEST>", playerList.map { it.displayName }, playerList, playerList.map { it.getTrackerNetworkUrl() })
	}

	@TestByNova
	fun testGetProfileProfiles() = runBlocking {
		val data = bungieApi.destiny2.getProfile(
			MembershipType.TigerSteam,
			4611686018500727480,
			listOf(DestinyComponentType.Profiles)
		).data

		spark("GetProfileProfiles<TEST>", data)
	}

	@TestByNova
	fun testGetProfileCollectibles() = runBlocking {
		val data = bungieApi.destiny2.getProfile(
			MembershipType.TigerSteam,
			4611686018500727480,
			listOf(DestinyComponentType.Collectibles)
		).data

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
