package dev.phyo.todoapp.domain.usecase

import dev.phyo.todoapp.data.local.entity.Task
import dev.phyo.todoapp.domain.repository.ITaskRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTasksUseCase @Inject constructor(private val repository: ITaskRepository) {
    operator fun invoke(): Flow<List<Task>> = repository.getAllTasks()
}