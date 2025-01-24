package dev.phyo.todoapp.domain.repository

import dev.phyo.todoapp.data.local.entity.Task
import kotlinx.coroutines.flow.Flow

interface ITaskRepository {
    fun getAllTasks(): Flow<List<Task>>
    suspend fun insertTask(task: Task)
    suspend fun deleteTask(task: Task)
}