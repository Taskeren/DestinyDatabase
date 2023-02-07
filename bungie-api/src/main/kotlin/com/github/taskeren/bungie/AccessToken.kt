package com.github.taskeren.bungie

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccessToken(
	@SerialName("access_token")
	val accessToken: String,
	@SerialName("token_type")
	val tokenType: String,
	@SerialName("expires_in")
	val expiresIn: Long,
	@SerialName("refresh_token")
	val refreshToken: String,
	@SerialName("refresh_expires_in")
	val refreshExpiresIn: Long,
	@SerialName("membership_id")
	val membershipId: String
)