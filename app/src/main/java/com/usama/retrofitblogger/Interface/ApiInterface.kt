package com.usama.retrofitblogger.Interface

import com.usama.retrofitblogger.Model.ModelApiResponse
import com.usama.retrofitblogger.Model.ModelNews
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("v2/top-headlines")
    fun getCurrentNews(@Query("country") country: String, @Query("apiKey") API: String
    ): Call<ModelNews>
}