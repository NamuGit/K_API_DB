package com.s.k_api.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// get instance of API
object RetrofitHelper {

    private const val BaseURL="https://api.spacexdata.com/"

    fun getAPIInstance(): Retrofit{
        return Retrofit.Builder().
        baseUrl(BaseURL).
        addConverterFactory(GsonConverterFactory.create()).
        build()
    }


}