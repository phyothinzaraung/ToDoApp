package dev.phyo.todoapp.data.repository

import dev.phyo.todoapp.data.helper.ITaskHelper
import dev.phyo.todoapp.data.local.entity.Task
import dev.phyo.todoapp.domain.repository.ITaskRepository
import kotlinx.coroutines.flow.Flow

class TaskRepositoryImpl(private val taskHelper: ITaskHelper): ITaskRepository {
    override fun getAllTasks(): Flow<List<Task>> = taskHelper.getAllTasks()

    override suspend fun insertTask(task: Task) = taskHelper.insertTask(task)

    override suspend fun deleteTask(task: Task) = taskHelper.deleteTask(task)
}