package dev.baseio.kronkmp.schedule

import kotlinx.datetime.Instant
import kotlin.time.Duration

data class Schedule(
    val interval: Duration? = null,
    val at: Instant? = null,
    val cron: String? = null // For future cron parser support
)