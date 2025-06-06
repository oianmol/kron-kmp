package dev.baseio.kronkmp.task

import dev.baseio.kronkmp.schedule.Schedule

data class RegisteredTask(val task: Task, val schedule: Schedule)
