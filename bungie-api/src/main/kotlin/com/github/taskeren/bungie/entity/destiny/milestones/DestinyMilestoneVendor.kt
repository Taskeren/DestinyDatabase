package com.github.taskeren.bungie.entity.destiny.milestones

import kotlinx.serialization.Serializable

@Serializable
data class DestinyMilestoneVendor(val vendorHash: UInt, val previewItemHash: UInt?)
