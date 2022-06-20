package com.s.k_api.network


import com.s.k_api.model.SpaceRocket
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// call to sub API
interface RetroAPIService {

    @GET("/v4/rockets")
    suspend fun getRockets(): Response<List<SpaceRocket>>

//    For Details of specific rocket
//    @GET("rockets")
//    suspend fun getRocketsDetails(@Query("/") id :Long): Response<SpaceRocket>






}