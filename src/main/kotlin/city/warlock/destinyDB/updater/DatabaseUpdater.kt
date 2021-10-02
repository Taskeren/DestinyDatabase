package city.warlock.destinyDB.updater

import city.warlock.d2api.BungieApi
import city.warlock.d2api.entity.destiny.config.DestinyManifest
import city.warlock.destinyDB.DestinyDatabase
import city.warlock.destinyDB.updater.tickets.UpdateTicket
import city.warlock.destinyDB.updater.tickets.UpdateTicketItemDefinition

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
		BungieApi.Destiny2.getDestinyManifest().let {
			cacheDestinyManifest = it
			return it
		}
	}

	fun updateItemDefinitions(vararg lang: Language) {
		executeTicket(UpdateTicketItemDefinition(*lang))
	}

}