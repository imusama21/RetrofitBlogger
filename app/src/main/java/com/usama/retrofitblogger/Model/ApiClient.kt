package com.usama.retrofitblogger.Model

import com.usama.retrofitblogger.Constants
import com.usama.retrofitblogger.Interface.ApiInterface
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    fun getApiService(): ApiInterface? {
        return Retrofit.Builder()
            .baseUrl(Constants.API_BASE_URL)
            .client(provideClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }

     fun provideClient(): OkHttpClient? {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(interceptor)
            .addInterceptor { chain: Interceptor.Chain ->
                val request = chain.request()
                chain.proceed(request)
            }.build()
    }

    fun  sumaa(){

    }

}