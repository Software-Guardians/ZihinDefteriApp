package com.emrullaheniscetinkaya.todoapplication.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emrullaheniscetinkaya.todoapplication.data.entity.ToDoList
import com.emrullaheniscetinkaya.todoapplication.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var toDoRepository: ToDoRepository):
    ViewModel(){


        var toDoList= MutableLiveData<List<ToDoList>>()

    fun hepsiniYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            toDoList.value=toDoRepository.toDoYukle()
        }
    }
    fun sil(toDoId: Int){
        CoroutineScope(Dispatchers.Main).launch {
            toDoRepository.sil(toDoId)
            hepsiniYukle()
        }
    }
    fun ara(aramaKelimesi: String){
        CoroutineScope(Dispatchers.Main).launch {
            toDoList.value=toDoRepository.ara(aramaKelimesi)
        }
    }


}