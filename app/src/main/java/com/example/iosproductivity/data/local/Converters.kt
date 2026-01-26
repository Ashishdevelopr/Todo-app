package com.example.iosproductivity.data.local

import androidx.room.TypeConverter
import com.example.iosproductivity.domain.model.TaskCategory
import com.example.iosproductivity.domain.model.TaskPriority
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Converters {
    private val dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE
    private val dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

    @TypeConverter
    fun fromTimestamp(value: String?): LocalDate? {
        return value?.let { LocalDate.parse(it, dateFormatter) }
    }

    @TypeConverter
    fun dateToTimestamp(date: LocalDate?): String? {
        return date?.format(dateFormatter)
    }

    @TypeConverter
    fun fromDateTimeTimestamp(value: String?): LocalDateTime? {
        return value?.let { LocalDateTime.parse(it, dateTimeFormatter) }
    }

    @TypeConverter
    fun dateTimeToTimestamp(date: LocalDateTime?): String? {
        return date?.format(dateTimeFormatter)
    }

    @TypeConverter
    fun fromCategory(value: String): TaskCategory {
        return try {
            TaskCategory.valueOf(value)
        } catch (e: Exception) {
            TaskCategory.PERSONAL
        }
    }

    @TypeConverter
    fun categoryToString(category: TaskCategory): String {
        return category.name
    }

    @TypeConverter
    fun fromPriority(value: String): TaskPriority {
        return try {
            TaskPriority.valueOf(value)
        } catch (e: Exception) {
            TaskPriority.MEDIUM
        }
    }

    @TypeConverter
    fun priorityToString(priority: TaskPriority): String {
        return priority.name
    }
}
