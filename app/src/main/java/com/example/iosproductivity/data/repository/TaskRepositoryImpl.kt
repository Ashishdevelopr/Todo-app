package com.example.iosproductivity.data.repository

import com.example.iosproductivity.data.local.TaskDao
import com.example.iosproductivity.data.local.toEntity
import com.example.iosproductivity.domain.model.Task
import com.example.iosproductivity.domain.repository.TaskRepository
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(
    private val taskDao: TaskDao
) : TaskRepository {

    override fun getTasksStream(): Flow<List<Task>> {
        return taskDao.getAllTasks().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override fun getTaskStream(id: String): Flow<Task?> {
        return taskDao.getTaskById(id).map { it?.toDomain() }
    }

    override fun getTasksForDateStream(date: LocalDate): Flow<List<Task>> {
        // Simple filter in memory for now, or add Query in DAO
        return taskDao.getAllTasks().map { entities ->
            entities.map { it.toDomain() }
                .filter { it.dueDate == date }
        }
    }

    override suspend fun insertTask(task: Task) {
        taskDao.insertTask(task.toEntity())
    }

    override suspend fun deleteTask(taskId: String) {
        taskDao.deleteTask(taskId)
    }

    override suspend fun updateTaskStatus(taskId: String, isCompleted: Boolean) {
        val completedAt = if (isCompleted) LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) else null
        taskDao.updateTaskStatus(taskId, isCompleted, completedAt)
    }

    override suspend fun syncTasks() {
        // TODO: Implement Cloud Sync
    }
}
