package com.example.iosproductivity.di

import android.app.Application
import androidx.room.Room
import com.example.iosproductivity.data.local.AppDatabase
import com.example.iosproductivity.data.local.TaskDao
import com.example.iosproductivity.data.repository.TaskRepositoryImpl
import com.example.iosproductivity.domain.repository.TaskRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            "ios_productivity_db"
        ).fallbackToDestructiveMigration() // For simplicity in dev
         .build()
    }

    @Provides
    @Singleton
    fun provideTaskDao(db: AppDatabase): TaskDao {
        return db.taskDao()
    }

    @Provides
    @Singleton
    fun provideTaskRepository(taskDao: TaskDao): TaskRepository {
        return TaskRepositoryImpl(taskDao)
    }
}
