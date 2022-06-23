package com.s.k_api.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.s.k_api.R
import com.s.k_api.repository.SpaceRepository
import com.s.k_api.adapter.FirstRVAdapter
import com.s.k_api.databinding.ActivityMainBinding
import com.s.k_api.db.RocketDBHelper
import com.s.k_api.network.RetroAPIService
import com.s.k_api.network.RetrofitHelper
import com.s.k_api.viewmodel.MyViewModelFactory
import com.s.k_api.viewmodel.SpaceViewModel

class MainActivity : AppCompatActivity() {

    // data binding class
    private lateinit var  binding: ActivityMainBinding
    private val TAG = "API_DATA"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)   // bind xml file
        setContentView(binding.root)
        val recyclerView = binding.firstRecyclerView

        lateinit var viewModel: SpaceViewModel
        val retroInstance = RetrofitHelper.getAPIInstance().create(RetroAPIService::class.java)  // API instance
        val dbInstance = RocketDBHelper.getDBInstance(this)                               // DB instance
        val spaceRepository = SpaceRepository(dbInstance,retroInstance,applicationContext)        // Repo


        viewModel = ViewModelProvider(this, MyViewModelFactory(spaceRepository))
            .get(SpaceViewModel::class.java)    // create obj of this view model


        // send data to recycler view from view model
        viewModel.rocket.observe(this, Observer {
            Log.d(TAG, "country: ${it} "+ "\n")
            recyclerView.adapter = FirstRVAdapter(it)
            recyclerView.layoutManager =LinearLayoutManager(this)
        })

    }
}