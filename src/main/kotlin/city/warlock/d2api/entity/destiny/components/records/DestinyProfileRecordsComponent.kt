package city.warlock.d2api.entity.destiny.components.records

data class DestinyProfileRecordsComponent(
	val score: Int,
	val activeScore: Int,
	val legacyScore: Int,
	val lifetimeScore: Int,
	val trackedRecordHash: UInt?,
	val records: Map<UInt, DestinyRecordComponent>,
	val recordCategoriesRootNodeHash: UInt,
	val recordSealsRootNodeHash: UInt
)
