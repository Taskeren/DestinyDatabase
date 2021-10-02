package city.warlock.d2api.entity.destiny.entities.profiles

import city.warlock.d2api.entity.user.UserInfoCard
import java.util.*

data class DestinyProfileComponent(
	val userInfo: UserInfoCard,
	val dateLastPlayed: Date,
	val versionsOwned: Int,
	val characterIds: List<Long>,
	val seasonHashes: List<UInt>,
	val currentSeasonHash: UInt?,
	val currentSeasonRewardPowerCap: Int?
)
