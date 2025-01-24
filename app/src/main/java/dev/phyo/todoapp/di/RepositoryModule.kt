package dev.phyo.todoapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dev.phyo.todoapp.data.helper.ITaskHelper
import dev.phyo.todoapp.data.repository.TaskRepositoryImpl
import dev.phyo.todoapp.domain.repository.ITaskRepository

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    @Provides
    fun providesTaskRepository(taskHelper: ITaskHelper): ITaskRepository = TaskRepositoryImpl(taskHelper)
}