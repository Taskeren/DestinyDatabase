package com.github.taskeren.bungie.entity.destiny.entities.profiles

import com.github.taskeren.bungie.entity.user.UserInfoCard
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.OffsetDateTime

@Serializable
data class DestinyProfileComponent(
	val userInfo: UserInfoCard,
	@Contextual
	val dateLastPlayed: OffsetDateTime,
	val versionsOwned: Int,
	val characterIds: List<Long>,
	val seasonHashes: List<UInt>,
	val currentSeasonHash: UInt?,
	val currentSeasonRewardPowerCap: Int?
)
