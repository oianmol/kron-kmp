package dev.baseio.kronkmp.runner

import kotlinx.coroutines.CoroutineScope

expect class TaskRunner() {
    fun start(scope: CoroutineScope)
}