package com.s.k_api.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.s.k_api.model.RocketDetails
import com.s.k_api.repository.SpaceRepository
import com.s.k_api.model.SpaceRocket
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SpaceViewModel(private val spaceRepository: SpaceRepository , private var id: String): ViewModel(){

    // get data from repository , as its Livedata so used coroutine viewModelScope
    init {
        viewModelScope.launch (Dispatchers.IO)  {
            spaceRepository.getRocketListfromRepo()
            spaceRepository.getRocketDetailsfromRepo(id)

        }
    }

    // pass Live data to Activity
    val rocket: LiveData<List<SpaceRocket>> // declared a variable "rocket" to store data from repo and pass to activity
    get() = spaceRepository.rocket   // this "rocket" val is from repository


    // pass Live data to Activity
    val details: LiveData<RocketDetails >// declared a variable "rocket" to store data from repo and pass to activity
    get() = spaceRepository.details   // this "rocket" val is from repository





}