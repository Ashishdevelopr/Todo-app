package com.example.iosproductivity.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.iosproductivity.domain.model.Task
import com.example.iosproductivity.domain.model.TaskCategory
import com.example.iosproductivity.domain.model.TaskPriority
import java.time.LocalDate
import java.time.LocalDateTime

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey val id: String,
    val title: String,
    val category: TaskCategory,
    val priority: TaskPriority,
    val effort: Int,
    val estimatedTimeMinutes: Int,
    val dueDate: LocalDate?,
    val isCompleted: Boolean,
    val createdAt: LocalDateTime,
    val completedAt: LocalDateTime?
) {
    fun toDomain(): Task {
        return Task(
            id = id,
            title = title,
            category = category,
            priority = priority,
            effort = effort,
            estimatedTimeMinutes = estimatedTimeMinutes,
            dueDate = dueDate,
            isCompleted = isCompleted,
            createdAt = createdAt,
            completedAt = completedAt
        )
    }
}

fun Task.toEntity(): TaskEntity {
    return TaskEntity(
        id = id,
        title = title,
        category = category,
        priority = priority,
        effort = effort,
        estimatedTimeMinutes = estimatedTimeMinutes,
        dueDate = dueDate,
        isCompleted = isCompleted,
        createdAt = createdAt,
        completedAt = completedAt
    )
}
