package com.github.taskeren.bungie.entity.destiny

import kotlinx.serialization.Serializable

@Serializable
data class DestinyStat(val statHash: UInt, val value: Int)
