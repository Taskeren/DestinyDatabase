package com.github.taskeren.bungie.entity.destiny.misc

import kotlinx.serialization.Serializable

/* red, green, blue, alpha 应该为 Byte 类型 */
@Serializable
data class DestinyColor(val colorHash: UInt, val red: Int, val green: Int, val blue: Int, val alpha: Int)
