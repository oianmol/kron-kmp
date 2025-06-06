package dev.baseio.kronkmp

import dev.baseio.kronkmp.runner.TaskRunner
import dev.baseio.kronkmp.schedule.Schedule
import dev.baseio.kronkmp.task.Task
import dev.baseio.kronkmp.task.TaskRegistry
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlin.time.Duration.Companion.minutes

fun every(minutes: Int): Schedule = Schedule(interval = minutes.minutes)
fun scheduleAt(instant: Instant): Schedule = Schedule(at = instant)

fun registerTask(id: String, schedule: Schedule, block: suspend () -> Unit) {
    val task = object : Task {
        override val id = id
        override suspend fun execute() = block()
    }
    TaskRegistry.register(task, schedule)
}

// Example usage in commonMain
fun main() {
    val scope = CoroutineScope(Dispatchers.Default)
    registerTask("sync", every(5)) {
        println("Running sync task at ${Clock.System.now()}")
    }
    TaskRunner(scope).start()
}