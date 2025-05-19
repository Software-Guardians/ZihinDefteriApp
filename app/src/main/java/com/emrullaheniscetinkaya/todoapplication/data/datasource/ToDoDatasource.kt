package com.emrullaheniscetinkaya.todoapplication.data.datasource

import com.emrullaheniscetinkaya.todoapplication.data.entity.ToDoList
import com.emrullaheniscetinkaya.todoapplication.room.ToDoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class ToDoDatasource(var toDoDao: ToDoDao) {
    suspend fun kaydet(toDoAd: String,toDoText: String){
        var toDoList= ToDoList(0,toDoAd,toDoText)
        toDoDao.kaydet(toDoList)

    }
    suspend fun guncelle(toDoId: Int,toDoAd: String,toDoText: String){
        var toDoList= ToDoList(toDoId,toDoAd,toDoText)
        toDoDao.guncelle(toDoList)
    }
    suspend fun ara(aramaKelimesi: String): List<ToDoList> = withContext(Dispatchers.IO){
        toDoDao.ara(aramaKelimesi)


    }
    suspend fun toDoYukle(): List<ToDoList> =withContext(Dispatchers.IO) {
        return@withContext toDoDao.toDoYukle()
    }
    suspend fun sil(toDoId: Int){
        toDoDao.sil(toDoId)
    }

}