package com.emrullaheniscetinkaya.todoapplication.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.emrullaheniscetinkaya.todoapplication.data.entity.ToDoList

@Database(entities = [ToDoList::class], version = 1)
abstract class Database: RoomDatabase() {
    abstract fun getToDoDao(): ToDoDao
}