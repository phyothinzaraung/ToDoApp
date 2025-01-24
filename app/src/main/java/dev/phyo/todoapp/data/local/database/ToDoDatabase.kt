package dev.phyo.todoapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.phyo.todoapp.data.local.dao.TaskDao
import dev.phyo.todoapp.data.local.entity.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class ToDoDatabase: RoomDatabase() {
    abstract val taskDao: TaskDao
}