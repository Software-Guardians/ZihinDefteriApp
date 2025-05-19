package com.emrullaheniscetinkaya.todoapplication.data.repo

import com.emrullaheniscetinkaya.todoapplication.data.datasource.ToDoDatasource
import com.emrullaheniscetinkaya.todoapplication.data.entity.ToDoList
import kotlinx.coroutines.flow.Flow

class ToDoRepository(var datasource: ToDoDatasource) {
    suspend fun guncelle(toDoId: Int,toDoName: String,toDoText: String)=datasource.guncelle(toDoId,toDoName,toDoText)
    suspend fun sil(toDoId: Int)=datasource.sil(toDoId)
    suspend fun ara(aramaKelimesi: String)=datasource.ara(aramaKelimesi)
    suspend fun kaydet(toDoName: String,toDoText: String)=datasource.kaydet(toDoName,toDoText)
    suspend fun toDoYukle():
           List<ToDoList>  = datasource.toDoYukle()
}