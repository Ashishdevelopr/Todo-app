package com.example.iosproductivity.domain.logic

import com.example.iosproductivity.domain.model.DailyAnalytics
import com.example.iosproductivity.domain.model.InsightType
import com.example.iosproductivity.domain.model.ProductivityInsight
import com.example.iosproductivity.domain.model.Task
import java.time.LocalDate

class AnalyticsCalculator {

    fun calculateDailyAnalytics(tasks: List<Task>, date: LocalDate): DailyAnalytics {
        val daysTasks = tasks.filter { it.dueDate == date || (it.completedAt?.toLocalDate() == date) }
        val completed = daysTasks.count { it.isCompleted }
        val pending = daysTasks.count { !it.isCompleted }
        
        val totalEffort = daysTasks.sumOf { it.effort }
        val completedEffort = daysTasks.filter { it.isCompleted }.sumOf { it.effort }
        
        val score = if (totalEffort > 0) (completedEffort.toFloat() / totalEffort * 100).toInt() else 0
        
        return DailyAnalytics(
            date = date,
            completedTasks = completed,
            pendingTasks = pending,
            productivityScore = score,
            consistency = 1.0f // Simplified for single day
        )
    }

    fun generateInsights(tasks: List<Task>): List<ProductivityInsight> {
        val insights = mutableListOf<ProductivityInsight>()
        val overdueTasks = tasks.filter { !it.isCompleted && it.dueDate?.isBefore(LocalDate.now()) == true }
        
        if (overdueTasks.isNotEmpty()) {
            insights.add(ProductivityInsight("You have ${overdueTasks.size} overdue tasks. Consider rescheduling.", InsightType.WARNING))
        }

        if (tasks.count { it.isCompleted } > 5) {
            insights.add(ProductivityInsight("Great momentum today!", InsightType.PRAISE))
        }

        return insights
    }
}
