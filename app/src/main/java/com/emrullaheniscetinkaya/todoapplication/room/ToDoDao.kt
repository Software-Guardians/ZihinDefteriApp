package com.emrullaheniscetinkaya.todoapplication.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.emrullaheniscetinkaya.todoapplication.data.entity.ToDoList
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {
    @Query("select * from ToDoMain")
    suspend fun toDoYukle(): List<ToDoList>
    @Insert
    suspend fun kaydet(toDoList: ToDoList)

    @Update
    suspend fun guncelle(toDoList: ToDoList)

    @Query("delete from ToDoMain where to_do_id=:toDoId")
    suspend fun sil(toDoId: Int)



    @Query("SELECT * FROM ToDoMain WHERE to_do_ad LIKE '%' || :query || '%' OR to_do_text LIKE '%' || :query || '%'")
    fun ara(query: String): List<ToDoList>
}