package com.emrullaheniscetinkaya.todoapplication.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.emrullaheniscetinkaya.todoapplication.R
import com.emrullaheniscetinkaya.todoapplication.databinding.ActivityMainBinding
import com.emrullaheniscetinkaya.todoapplication.databinding.FragmentToDoKayitBinding
import com.emrullaheniscetinkaya.todoapplication.ui.viewmodel.AnasayfaViewModel
import com.emrullaheniscetinkaya.todoapplication.ui.viewmodel.ToDoKayitViewModel
import com.emrullaheniscetinkaya.todoapplication.utils.gecisYap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ToDoKayitFragment : Fragment() {
    private val viewModel: ToDoKayitViewModel by viewModels()
    private lateinit var binding: FragmentToDoKayitBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentToDoKayitBinding.inflate(inflater,container,false)
        binding.buttonKayit.setOnClickListener {
            val name=binding.editTextKayitAd.text.toString()
            val text=binding.editTextKayitMetin.text.toString()
            viewModel.kaydet(name,text)
            Navigation.gecisYap(it,R.id.KayitToAnasayfa)
        }
        return binding.root
    }

}