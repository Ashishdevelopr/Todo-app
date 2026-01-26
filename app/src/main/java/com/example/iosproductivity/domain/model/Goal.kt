package com.example.iosproductivity.domain.model

import java.time.LocalDate

enum class GoalPeriod {
    WEEKLY, MONTHLY, YEARLY
}

enum class GoalType {
    TASKS_COMPLETED,
    HOURS_FOCUSED, // requires time tracking
    CATEGORY_CONSISTENCY // e.g. "Do 3 Health tasks"
}

data class Goal(
    val id: String,
    val title: String,
    val period: GoalPeriod,
    val type: GoalType,
    val targetAmount: Int,
    val currentAmount: Int,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val linkedCategory: TaskCategory? = null
)
