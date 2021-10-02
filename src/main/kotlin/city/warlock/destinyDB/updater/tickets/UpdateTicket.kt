package city.warlock.destinyDB.updater.tickets

import city.warlock.destinyDB.updater.DatabaseUpdater
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

interface UpdateTicket {

	val logger: Logger
		get() = LogManager.getLogger()

	@OptIn(ExperimentalSerializationApi::class)
	val ktJson: Json
		get() = Json {
			explicitNulls = false
			ignoreUnknownKeys = true
		}

	fun execute(updater: DatabaseUpdater);

}