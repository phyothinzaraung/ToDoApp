package dev.phyo.todoapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dev.phyo.todoapp.data.helper.ITaskHelper
import dev.phyo.todoapp.data.helper.ITaskHelperImpl
import dev.phyo.todoapp.data.local.dao.TaskDao

@Module
@InstallIn(ViewModelComponent::class)
object HelperModule {

    @Provides
    fun providesTaskHelper(taskDao: TaskDao): ITaskHelper = ITaskHelperImpl(taskDao)
}