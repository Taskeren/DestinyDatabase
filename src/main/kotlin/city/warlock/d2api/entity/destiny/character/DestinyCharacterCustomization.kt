package city.warlock.d2api.entity.destiny.character

data class DestinyCharacterCustomization(
	val personality: UInt,
	val face: UInt,
	val skinColor: UInt,
	val lipColor: UInt,
	val eyeColor: UInt,
	val hairColors: List<UInt>,
	val featureColors: List<UInt>,
	val decalColor: UInt,
	val wearHelmet: Boolean,
	val hairIndex: Int,
	val featureIndex: Int,
	val decalIndex: Int
)
