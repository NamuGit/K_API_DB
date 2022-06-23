package com.s.k_api.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.s.k_api.R

import com.s.k_api.databinding.ActivityDetailsScreenBinding
import com.s.k_api.db.RocketDBHelper
import com.s.k_api.network.RetroAPIService
import com.s.k_api.network.RetrofitHelper
import com.s.k_api.repository.SpaceRepository
import com.s.k_api.viewmodel.MyViewModelFactory
import com.s.k_api.viewmodel.MyViewModelFactoryDetails

import com.s.k_api.viewmodel.SpaceViewModel

class DetailsScreen : AppCompatActivity() {

    lateinit private var  detail_binding : ActivityDetailsScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detail_binding = DataBindingUtil.setContentView(this,R.layout.activity_details_screen)
//        var details_recyclerView= detail_binding.detailsRecyclerView

        var bundle: Bundle? = intent.extras
        var ID = bundle!!.getString("ID")
        Log.d("tag_UUUUUUUUUUUUU","ID"+ID)

        // Instance of All the classes (Retrofit , DB , Repo, viewmodel)
        val viewModel : SpaceViewModel

        val retroInstance = RetrofitHelper.getAPIInstance().create(RetroAPIService::class.java)
        val DBInstance = RocketDBHelper.getDBInstance(this)
        val repository = SpaceRepository(DBInstance,retroInstance,applicationContext)

        viewModel = ViewModelProvider(this , MyViewModelFactoryDetails(repository, ID.toString())).get(SpaceViewModel::class.java)

        viewModel.details.observe(this, Observer {
//            details_recyclerView.adapter = DetailViewAdapter(it)
            detail_binding.rocketActive.text = it.active.toString()
            detail_binding.rocketName.text = it.name
            detail_binding.rocketCostPerLaunch.text = it.cost_per_launch.toString()
            detail_binding.rocketDesciption.text = it.description
            detail_binding.rocketWiki.text = it.wikipedia

            Log.d("Details","Value : ${it}")
        })









    }
}