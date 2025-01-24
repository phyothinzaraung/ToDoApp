package dev.phyo.todoapp.di

import android.content.Context
import androidx.room.Insert
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.phyo.todoapp.data.local.dao.TaskDao
import dev.phyo.todoapp.data.local.database.ToDoDatabase
import dev.phyo.todoapp.util.Constant.Companion.DB_NAME
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesTaskDao(database: ToDoDatabase): TaskDao = database.taskDao

    @Provides
    @Singleton
    fun providesTaskDatabase(@ApplicationContext context: Context): ToDoDatabase{
        return Room.databaseBuilder(
            context = context,
            ToDoDatabase::class.java,
            DB_NAME
        ).build()
    }


}