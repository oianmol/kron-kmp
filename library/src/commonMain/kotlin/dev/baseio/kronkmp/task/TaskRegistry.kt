package dev.baseio.kronkmp.task

import dev.baseio.kronkmp.schedule.Schedule

object TaskRegistry {
    private val tasks = mutableListOf<RegisteredTask>()

    fun register(task: Task, schedule: Schedule) {
        tasks.add(RegisteredTask(task, schedule))
    }

    fun allTasks(): List<RegisteredTask> = tasks.toList()
}