package com.example.iosproductivity.domain.model

data class DailyAnalytics(
    val date: java.time.LocalDate,
    val completedTasks: Int,
    val pendingTasks: Int,
    val productivityScore: Int, // 0-100
    val consistency: Float // 0.0 - 1.0
)

data class ProductivityInsight(
    val message: String,
    val type: InsightType
)

enum class InsightType {
    INFO, WARNING, TIP, PRAISE
}
