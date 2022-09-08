package com.github.taskeren.bungie.db.updater

import com.github.taskeren.bungie.db.DestinyDatabase
import com.github.taskeren.bungie.db.updater.tickets.UpdateTicket
import com.github.taskeren.bungie.db.updater.tickets.UpdateTicketItemDefinition
import com.github.taskeren.bungie.entity.destiny.config.DestinyManifest

class DatabaseUpdater(val database: DestinyDatabase) {

	var cacheDestinyManifest: DestinyManifest? = null

	// Assets Getter

	fun getDestinyManifest(): DestinyManifest {
		return cacheDestinyManifest ?: updateManifest()
	}

	// Update Methods

	fun executeTicket(ticket: UpdateTicket) {
		ticket.execute(this)
	}

	fun updateManifest(): DestinyManifest {
		return database.api.destiny2.getDestinyManifest().apply { cacheDestinyManifest = this }
	}

	fun updateItemDefinitions(vararg lang: Language) {
		executeTicket(UpdateTicketItemDefinition(database.api, *lang))
	}

}