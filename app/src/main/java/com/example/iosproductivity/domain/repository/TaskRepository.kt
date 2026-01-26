package com.example.iosproductivity.domain.repository

import com.example.iosproductivity.domain.model.Task
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface TaskRepository {
    fun getTasksStream(): Flow<List<Task>>
    fun getTaskStream(id: String): Flow<Task?>
    fun getTasksForDateStream(date: LocalDate): Flow<List<Task>>
    suspend fun insertTask(task: Task)
    suspend fun deleteTask(taskId: String)
    suspend fun updateTaskStatus(taskId: String, isCompleted: Boolean)
    suspend fun syncTasks()
}
