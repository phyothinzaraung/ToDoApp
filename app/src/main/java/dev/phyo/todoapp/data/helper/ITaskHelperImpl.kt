package dev.phyo.todoapp.data.helper

import dev.phyo.todoapp.data.local.dao.TaskDao
import dev.phyo.todoapp.data.local.entity.Task
import kotlinx.coroutines.flow.Flow

class ITaskHelperImpl(val taskDao: TaskDao): ITaskHelper {
    override fun getAllTasks(): Flow<List<Task>> = taskDao.getAllTasks()

    override suspend fun insertTask(task: Task) = taskDao.insertTask(task)

    override suspend fun deleteTask(task: Task) = taskDao.deleteTask(task)
}