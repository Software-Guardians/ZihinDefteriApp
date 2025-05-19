package com.emrullaheniscetinkaya.todoapplication.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.emrullaheniscetinkaya.todoapplication.R
import com.emrullaheniscetinkaya.todoapplication.databinding.FragmentToDoDetayBinding
import com.emrullaheniscetinkaya.todoapplication.ui.viewmodel.ToDoDetayViewModel
import com.emrullaheniscetinkaya.todoapplication.utils.gecisYap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ToDoDetayFragment : Fragment() {
    private val viewModel: ToDoDetayViewModel by viewModels()
    private lateinit var binding: FragmentToDoDetayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentToDoDetayBinding.inflate(inflater,container,false)
        val bundle: ToDoDetayFragmentArgs by navArgs()
        val gelenToDo=bundle.toDoListDetay
        binding.editTextDetayAd.setText(gelenToDo.to_do_ad)
        binding.editTextDetayMetin.setText(gelenToDo.to_do_text)
        binding.buttonDetay.setOnClickListener {
            val toDoAd=binding.editTextDetayAd.text.toString()
            val toDoText=binding.editTextDetayMetin.text.toString()
            viewModel.guncelle(gelenToDo.to_do_id,toDoAd,toDoText)
            Navigation.gecisYap(it,R.id.DetayToAnasayfa)
        }
        return binding.root
    }

}