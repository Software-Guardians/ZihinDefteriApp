package com.emrullaheniscetinkaya.todoapplication.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.emrullaheniscetinkaya.todoapplication.R
import com.emrullaheniscetinkaya.todoapplication.databinding.FragmentAnasayfaBinding
import com.emrullaheniscetinkaya.todoapplication.ui.adapter.ToDoAdapter
import com.emrullaheniscetinkaya.todoapplication.ui.viewmodel.AnasayfaViewModel
import com.emrullaheniscetinkaya.todoapplication.utils.gecisYap
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private lateinit var viewModel: AnasayfaViewModel
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var adapter: ToDoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnasayfaViewModel by viewModels()
        viewModel=tempViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentAnasayfaBinding.inflate(inflater,container,false)
        viewModel.hepsiniYukle()
        adapter= ToDoAdapter(requireContext(),emptyList(),viewModel)
        viewModel.toDoList.observe(viewLifecycleOwner) {
            adapter.setData(viewModel.toDoList.value)
        }


        binding.RecyclerView.adapter=adapter
        binding.RecyclerView.layoutManager= LinearLayoutManager(requireContext())
        binding.searchViewAnasayfa.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.ara(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.ara(newText)
                return true
            }
        })
        binding.floatingActionButtonAdd.setOnClickListener {
            Navigation.gecisYap(it,R.id.anasayfaToKayit)
        }

        return binding.root
    }

}