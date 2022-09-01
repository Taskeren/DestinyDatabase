package com.github.taskeren.bungie.entity.destiny.definitions

import kotlinx.serialization.Serializable

@Serializable
data class DestinyVendorInteractionReplyDefinition(val itemRewardSelection: Int, val reply: String, val replyType: Int)
