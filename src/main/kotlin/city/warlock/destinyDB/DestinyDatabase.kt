package city.warlock.destinyDB

import city.warlock.d2api.compat.BungieLanguage
import city.warlock.d2api.entity.destiny.definitions.DestinyInventoryItemDefinition
import city.warlock.destinyDB.doc.IdAndName
import city.warlock.destinyDB.updater.DatabaseUpdater
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection

class DestinyDatabase(connectionStr: String = "mongodb://localhost:27017/") {

	private val db: MongoDatabase

	init {
		db = KMongo.createClient(connectionStr).getDatabase("destiny2")
	}

	fun getDatabase(): MongoDatabase = db

	fun createUpdater(): DatabaseUpdater = DatabaseUpdater(this)

	fun getTranslation(bungieLanguage: BungieLanguage): MongoCollection<IdAndName> {
		return getDatabase().getCollection<IdAndName>("Translation_${bungieLanguage.name}")
	}

	fun getItemDefinition(bungieLanguage: BungieLanguage): MongoCollection<DestinyInventoryItemDefinition> {
		return getDatabase().getCollection<DestinyInventoryItemDefinition>("ItemDefinition_${bungieLanguage.name}")
	}

}