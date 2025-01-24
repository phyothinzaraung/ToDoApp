package dev.phyo.todoapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.phyo.todoapp.data.local.entity.Task
import dev.phyo.todoapp.domain.usecase.DeleteTaskUseCase
import dev.phyo.todoapp.domain.usecase.GetTasksUseCase
import dev.phyo.todoapp.domain.usecase.InsertTaskUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val getTasksUseCase: GetTasksUseCase,
    private val insertTaskUseCase: InsertTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase
): ViewModel() {

//    private val _tasks = MutableStateFlow<List<TaskEntity>>(emptyList())
//    val tasks: StateFlow<List<TaskEntity>>
//        get() = _tasks
//
//    init {
//        viewModelScope.launch {
//            getTasksUseCase().collect{
//                _tasks.value = it
//            }
//        }
//    }

    val tasks = getTasksUseCase().stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun addTask(title: String){
        viewModelScope.launch {
            insertTaskUseCase(Task(title=title))
        }
    }

    fun deleteTask(task: Task){
        viewModelScope.launch {
            deleteTaskUseCase(task)
        }
    }
}