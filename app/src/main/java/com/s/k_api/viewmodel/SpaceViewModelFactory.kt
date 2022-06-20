package com.s.k_api.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.s.k_api.repository.SpaceRepository

// Created when the ViewModel is parameterized i.e ViewModel has repo as parameter

class MyViewModelFactory (private val spaceRepository: SpaceRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SpaceViewModel(spaceRepository) as T
    }

}