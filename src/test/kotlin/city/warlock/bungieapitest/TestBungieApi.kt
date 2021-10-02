package city.warlock.bungieapitest

import city.warlock.d2api.BungieApi
import city.warlock.d2api.compat.EntityType
import city.warlock.d2api.compat.BungieLanguage
import city.warlock.d2api.entity.MembershipType
import city.warlock.d2api.entity.destiny.DestinyComponentType
import city.warlock.d2api.entity.user.psn
import city.warlock.d2api.entity.user.steam
import org.junit.jupiter.api.Test
import java.io.File
import java.util.*

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
		val manifest = BungieApi.Destiny2.getDestinyManifest()
		manifest.toString().writeToTempFile()

		manifest.getJsonWorldComponentContentPaths(
			BungieLanguage.Chinese,
			EntityType.DestinyInventoryItemLiteDefinition
		).notNullThen {
			BungieApi.Helpers.getBungieResource(this).body?.string().writeToTempJson("JsonWorldComponentContentPaths")
		}

		manifest.getJsonWorldContentPath(BungieLanguage.Chinese).notNullThen {
			BungieApi.Helpers.getBungieResource(this).body?.string().writeToTempJson("JsonWorldContentPaths")
		}
	}

	@Test
	fun testSearchDestinyPlayer() {
		// 找找我自己
		BungieApi.Destiny2.searchDestinyPlayer(MembershipType.All, "Taskeren-3#5322").let { userAccounts ->
			userAccounts.toBePrint()
			userAccounts.steam().let {
				it.getBungieGlobalDisplayNameAndCode().toBePrint("BungieGlobalName")
				it.getTrackerNetworkUrl().toBePrint("DestinyTracker-STEAM")
			}
			userAccounts.psn().let {
				it.getBungieGlobalDisplayNameAndCode().toBePrint("BungieGlobalName")
				it.getTrackerNetworkUrl().toBePrint("DestinyTracker-PSN")
			}
		}
	}

	@Test
	fun testGetProfile() {
		val membershipType = MembershipType.TigerSteam
		val membershipId = 4611686018500727480L
		BungieApi.Destiny2.getProfile(membershipType, membershipId, listOf(
			DestinyComponentType.ProfileInventories
		)).toBePrint("CharacterInventories")
	}

	@Test
	fun testGetItem() {
		val dmtHash = 3654674561U
		BungieApi.Destiny2.getItem(MembershipType.TigerSteam, 4611686018500727480L, 0L, listOf(DestinyComponentType.ItemPerks))
	}

	fun String?.writeToTempFile(ext: String = "txt", desc: String? = null) {
		if(this != null) {
			var description = desc
			if(desc == null) {
				description = "${this.substring(0, 3)}...${this.substring(this.length - 3)}"
			}
			File(File("./temp"), "${UUID.randomUUID()}-temp.$ext").let {
				println("Saving '$description' to '$it'")
				it.parentFile.mkdirs()
				it.createNewFile()
				it.writeText(this)
			}
		}
	}

	fun String?.writeToTempJson(desc: String? = null) = writeToTempFile(ext = "json", desc)

	fun Any?.toBePrint(desc: String? = null) = if(desc != null) println("$desc: $this") else println(this)

}