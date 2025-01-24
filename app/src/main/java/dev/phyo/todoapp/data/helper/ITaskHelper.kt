package dev.phyo.todoapp.data.helper

import dev.phyo.todoapp.data.local.entity.Task
import kotlinx.coroutines.flow.Flow

interface ITaskHelper {
    fun getAllTasks(): Flow<List<Task>>
    suspend fun insertTask(task: Task)
    suspend fun deleteTask(task: Task)
}