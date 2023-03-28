package com.github.taskeren.bungie.db.updater

import com.github.taskeren.bungie.db.DestinyDatabase
import com.github.taskeren.bungie.db.updater.tickets.UpdateTicket
import com.github.taskeren.bungie.db.updater.tickets.UpdateTicketItemDefinition
import com.github.taskeren.bungie.entity.destiny.config.DestinyManifest

class DatabaseUpdater(val database: DestinyDatabase) {

	var cacheDestinyManifest: DestinyManifest? = null

	// Assets Getter

	suspend fun getDestinyManifest(): DestinyManifest {
		return cacheDestinyManifest ?: updateManifest()
	}

	// Update Methods

	suspend fun executeTicket(ticket: UpdateTicket) {
		ticket.execute(this)
	}

	suspend fun updateManifest(): DestinyManifest {
		return database.api.destiny2.getDestinyManifest().data.apply { cacheDestinyManifest = this }
	}

	suspend fun updateItemDefinitions(vararg lang: Language) {
		executeTicket(UpdateTicketItemDefinition(database.api, *lang))
	}

}