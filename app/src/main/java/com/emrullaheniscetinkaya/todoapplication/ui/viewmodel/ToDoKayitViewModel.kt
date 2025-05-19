package com.emrullaheniscetinkaya.todoapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.emrullaheniscetinkaya.todoapplication.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToDoKayitViewModel @Inject constructor(var repository: ToDoRepository): ViewModel() {
    fun kaydet(toDoName: String,toDoText: String){
        CoroutineScope(Dispatchers.Main).launch {
            repository.kaydet(toDoName,toDoText)
        }

    }


}