package com.example.musictheory.home.homeApi

import com.example.musictheory.ExecutorBuildType
import com.example.musictheory.home.homeUtil.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        val okHttpClient = ExecutorBuildType.provideOkHttpClient()
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    val api by lazy {
        retrofit.create(CategoriesApi::class.java)
    }
}
