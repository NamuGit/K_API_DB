package com.s.k_api.network


import com.s.k_api.model.RocketDetails
import com.s.k_api.model.SpaceRocket
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


// call to sub API
interface RetroAPIService {


//    @PATCH("alerts/{alert_id}/accept")
//    fun accept_invited_alerts(@Header("X-Api-Token")  api_token: String, @Path("alert_id") alert_id: Int): Call<Unit>


    @GET("/v4/rockets")
    suspend fun getRockets(): Response<List<SpaceRocket>>

//    For Details of specific rocket
    @GET("/v4/rockets/{id}")
    suspend fun getRocketsDetails(@Path("id") id :String): Response<RocketDetails>
//    suspend fun getRocketsDetails(@Query("/") id :String): Response<List<RocketDetails>>


//    @GET("data/{version}/")
//    fun getWeatherReport1(@Path("version") version: String?): Call<Weather?>?

//    @Path(value = "id", encoded = false) key: Int





}