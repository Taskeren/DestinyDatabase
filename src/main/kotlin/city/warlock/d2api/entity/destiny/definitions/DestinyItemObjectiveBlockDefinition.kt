package city.warlock.d2api.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyItemObjectiveBlockDefinition(
	val objectiveHashes: List<UInt>,
	val displayActivityHashes: List<UInt>,
	val requireFullObjectiveCompletion: Boolean,
	val questlineItemHash: UInt,
	val narrative: String,
	val objectiveVerbName: String,
	val questTypeIdentifier: String,
	val questTypeHash: UInt,
	val perObjectiveDisplayProperties: List<DestinyObjectiveDisplayProperties>,
	val displayAsStatTracker: Boolean
)
