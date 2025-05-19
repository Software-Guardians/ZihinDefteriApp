package com.emrullaheniscetinkaya.todoapplication.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.emrullaheniscetinkaya.todoapplication.data.entity.ToDoList
import com.emrullaheniscetinkaya.todoapplication.databinding.CardTasarimLayoutBinding
import com.emrullaheniscetinkaya.todoapplication.ui.fragment.AnasayfaFragmentDirections
import com.emrullaheniscetinkaya.todoapplication.ui.viewmodel.AnasayfaViewModel
import com.emrullaheniscetinkaya.todoapplication.utils.gecisYap
import com.google.android.material.snackbar.Snackbar

class ToDoAdapter(var mContext: Context,var toDoList: List<ToDoList>,var viewModel: AnasayfaViewModel): RecyclerView.Adapter<ToDoAdapter.cardTutucu> (){
    fun setData(newList: List<ToDoList>){
        toDoList=newList
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): cardTutucu {
        var binding= CardTasarimLayoutBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return cardTutucu(binding)


    }

    override fun onBindViewHolder(
        holder: cardTutucu,
        position: Int
    ) {
        val toDo=toDoList.get(position)
        val t=holder.tasarimBinding
        t.textViewAd.text=toDo.to_do_ad
        var kisaMetin=toDo.to_do_text.take(50)
        t.textViewText.text=kisaMetin
        if (toDo.to_do_text.length>=50){
            t.textViewText.text=kisaMetin+"(...)"
        }
        t.imageViewDelete.setOnClickListener {
            Snackbar.make(it,"${toDo.to_do_ad} silinsin mi?", Snackbar.LENGTH_SHORT).setAction("Evet") {
                viewModel.sil(toDo.to_do_id)
            }.show()
        }
        t.CardView.setOnClickListener {
            val gecis= AnasayfaFragmentDirections.anasayfaToDetay(toDoListDetay = toDo)
            Navigation.gecisYap(it,gecis)
        }

    }

    override fun getItemCount(): Int {
         return toDoList.size
        }

    inner class cardTutucu(var tasarimBinding: CardTasarimLayoutBinding): RecyclerView.ViewHolder(tasarimBinding.root)


}