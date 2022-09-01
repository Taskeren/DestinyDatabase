package com.github.taskeren.bungie.entity.destiny

import kotlinx.serialization.Serializable

@Serializable
data class DyeReference(val channelHash: UInt, val dyeHash: UInt)
