package com.github.taskeren.bungie.entity

import kotlinx.serialization.Serializable

@Serializable
data class SingleComponentResponse<T>(val data: T, val privacy: Int, val disabled: Boolean? = null)
