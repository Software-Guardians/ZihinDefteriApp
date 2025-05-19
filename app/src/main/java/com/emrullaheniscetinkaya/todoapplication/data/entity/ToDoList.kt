package com.emrullaheniscetinkaya.todoapplication.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "ToDoMain")
data class ToDoList(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "to_do_id") var to_do_id: Int,
    @ColumnInfo(name = "to_do_ad") var to_do_ad: String,
    @ColumnInfo(name = "to_do_text") var to_do_text: String
) : Serializable{
}