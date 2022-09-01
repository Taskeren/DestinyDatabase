package com.github.taskeren.bungie.entity

data class SingleComponentResponse<T>(val data: T, val privacy: Int, val disabled: Boolean?)
