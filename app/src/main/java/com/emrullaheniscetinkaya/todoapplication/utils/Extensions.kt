package com.emrullaheniscetinkaya.todoapplication.utils

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation


fun Navigation.gecisYap(it: View,id: Int){

    findNavController(it).navigate(id)
}
fun Navigation.gecisYap(it: View,id: NavDirections){
    findNavController(it).navigate(id)
}