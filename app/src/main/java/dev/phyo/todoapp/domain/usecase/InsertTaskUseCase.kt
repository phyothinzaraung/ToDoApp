package dev.phyo.todoapp.domain.usecase

import dev.phyo.todoapp.data.local.entity.Task
import dev.phyo.todoapp.domain.repository.ITaskRepository
import javax.inject.Inject

class InsertTaskUseCase @Inject constructor(private val taskRepository: ITaskRepository) {
    suspend operator fun invoke(task: Task) = taskRepository.insertTask(task)
}