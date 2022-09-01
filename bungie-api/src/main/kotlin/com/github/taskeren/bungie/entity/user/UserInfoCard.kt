package com.github.taskeren.bungie.entity.user

import com.github.taskeren.bungie.entity.MembershipType
import com.github.taskeren.bungie.entity.toMembershipType
import kotlinx.serialization.Serializable

@Serializable
data class UserInfoCard(
	val iconPath: String? = null,
	val crossSaveOverride: Int,
	val applicableMembershipTypes: List<Int>,
	val isPublic: Boolean,
	val membershipType: Int,
	val membershipId: Long,
	val displayName: String,
	val bungieGlobalDisplayName: String,
	val bungieGlobalDisplayNameCode: Short?
) {

	fun enumMembershipType(): MembershipType = membershipType.toMembershipType()

	fun getTrackerNetworkUrl(): String? =
		enumMembershipType().trackerName?.let {
			"https://destinytracker.com/destiny-2/profile/${enumMembershipType().trackerName}/$membershipId/overview"
		}

	fun getBungieGlobalDisplayNameAndCode(): String = "$bungieGlobalDisplayName#$bungieGlobalDisplayNameCode"

}

fun List<UserInfoCard>.steam() = this.first { it.enumMembershipType() == MembershipType.TigerSteam }
fun List<UserInfoCard>.psn() = this.first { it.enumMembershipType() == MembershipType.TigerPsn }
fun List<UserInfoCard>.xbox() = this.first { it.enumMembershipType() == MembershipType.TigerXbox }