package com.s.k_api.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.s.k_api.activity.DetailsScreen
import com.s.k_api.databinding.FirstviewBinding
import com.s.k_api.model.SpaceRocket

class FirstRVAdapter(private val AdapterrocketList: List<SpaceRocket>):RecyclerView.Adapter<MyViewHolder>() {

     var context : Context ?=null;
    // inflate item view layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val binding = FirstviewBinding.inflate(inflater)
        context = parent.getContext();
        return MyViewHolder(binding)
    }

    // sent position to view holder to set item view data
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(AdapterrocketList[position],context)
    }

    override fun getItemCount(): Int {
        return AdapterrocketList.size}

    }

// set data to the item views in recycle view
class MyViewHolder(val binding: FirstviewBinding): RecyclerView.ViewHolder(binding.root){


        fun bind(value: SpaceRocket, context: Context? ){
            binding.nameTextView.text = value.name
            binding.countryTextView.text = value.country
//            Log.d("Adapterclass", "value"+value.name )



            binding.cardView.setOnClickListener {
                Toast.makeText(context , "ID: "+value.id ,Toast.LENGTH_LONG).show()
                var intent = Intent(context , DetailsScreen::class.java)
                var id = value.id
                intent.putExtra("ID",id)
                context?.startActivity(intent)
            }

        }



}