package com.github.taskeren.bungie.entity

import kotlinx.serialization.Serializable

@Serializable
data class DictionaryComponentResponse<K, V>(val data: Map<K, V>, val privacy: Int, val disabled: Boolean? = null)
