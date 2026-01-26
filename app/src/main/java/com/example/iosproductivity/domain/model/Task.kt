package com.example.iosproductivity.domain.model

import java.time.LocalDate
import java.time.LocalDateTime

enum class TaskCategory {
    WORK, HEALTH, LEARNING, PERSONAL, FINANCE, CUSTOM
}

enum class TaskPriority {
    LOW, MEDIUM, HIGH
}

data class Task(
    val id: String, // UUID
    val title: String,
    val category: TaskCategory,
    val priority: TaskPriority,
    val effort: Int, // 1-5
    val estimatedTimeMinutes: Int,
    val dueDate: LocalDate? = null,
    val isCompleted: Boolean = false,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val completedAt: LocalDateTime? = null
)
