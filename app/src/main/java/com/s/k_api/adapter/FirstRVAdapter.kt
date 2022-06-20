package com.s.k_api.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.s.k_api.databinding.FirstviewBinding
import com.s.k_api.model.SpaceRocket

class FirstRVAdapter(private val AdapterrocketList: List<SpaceRocket>):RecyclerView.Adapter<MyViewHolder>() {

    // inflate item view layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val binding = FirstviewBinding.inflate(inflater)
        return MyViewHolder(binding)
    }

    // sent position to view holder to set item view data
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bind(AdapterrocketList[position])
    }

    override fun getItemCount(): Int {
        return AdapterrocketList.size}

    }

// set data to the item views in recycle view
class MyViewHolder(val binding: FirstviewBinding): RecyclerView.ViewHolder(binding.root){


        fun bind( value : SpaceRocket){
            binding.nameTextView.text = value.name
            binding.countryTextView.text = value.country
//            Log.d("Adapterclass", "value"+value.name )
        }


}