package city.warlock.destinyDB

import city.warlock.d2api.entity.destiny.definitions.DestinyInventoryItemDefinition
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoIterable
import org.litote.kmongo.find
import org.litote.kmongo.findOne

// Item Definition Tricks

fun MongoCollection<DestinyInventoryItemDefinition>.findByHash(hash: UInt): DestinyInventoryItemDefinition? {
	return this.findOne("""{"hash": ${hash.toInt()}}""")
}

fun MongoCollection<DestinyInventoryItemDefinition>.findByName(name: String): MongoIterable<DestinyInventoryItemDefinition> {
	return this.find("""{"displayProperties.name": "$name"}""")
}