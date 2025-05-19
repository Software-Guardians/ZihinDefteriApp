package com.emrullaheniscetinkaya.todoapplication.di

import android.content.Context
import androidx.room.Room
import com.emrullaheniscetinkaya.todoapplication.data.datasource.ToDoDatasource
import com.emrullaheniscetinkaya.todoapplication.data.repo.ToDoRepository
import com.emrullaheniscetinkaya.todoapplication.room.Database
import com.emrullaheniscetinkaya.todoapplication.room.ToDoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideToDoRepository(toDoDatasource: ToDoDatasource): ToDoRepository{
        return ToDoRepository(toDoDatasource)
    }
    @Provides
    @Singleton
    fun provideToDoDataSource(toDoDao: ToDoDao): ToDoDatasource{
        return ToDoDatasource(toDoDao)
    }
    @Provides
    @Singleton
    fun provideToDoDao(@ApplicationContext context: Context): ToDoDao{
        val database= Room.databaseBuilder<Database>(context,"to_do_list.sqlite").build()
        return database.getToDoDao()
    }
}