package dev.baseio.kronkmp.task

interface Task {
    val id: String
    suspend fun execute()
}