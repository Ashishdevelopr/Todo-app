package com.example.iosproductivity.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.iosproductivity.domain.model.Task
import com.example.iosproductivity.domain.model.TaskCategory
import com.example.iosproductivity.domain.model.TaskPriority
import com.example.iosproductivity.domain.repository.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val repository: TaskRepository
) : ViewModel() {

    val tasks: StateFlow<List<Task>> = repository.getTasksStream()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun addTask(title: String, category: TaskCategory, priority: TaskPriority) {
        viewModelScope.launch {
            repository.insertTask(
                Task(
                    id = UUID.randomUUID().toString(),
                    title = title,
                    category = category,
                    priority = priority,
                    effort = 1,
                    estimatedTimeMinutes = 30,
                    dueDate = LocalDate.now()
                )
            )
        }
    }

    fun toggleTaskCompletion(task: Task) {
        viewModelScope.launch {
            repository.updateTaskStatus(task.id, !task.isCompleted)
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            repository.deleteTask(task.id)
        }
    }
}
