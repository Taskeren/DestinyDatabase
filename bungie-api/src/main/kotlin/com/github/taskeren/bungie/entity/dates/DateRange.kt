package com.github.taskeren.bungie.entity.dates

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.OffsetDateTime

@Serializable
data class DateRange(@Contextual val start: OffsetDateTime, @Contextual val end: OffsetDateTime)
