package com.example.musictheory.home.homeApi

import com.example.musictheory.trainingtest.data.model.ServerResponseMusicTest
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CategoriesApi {
//    @GET("get_data/")
//    suspend fun getCategories(
//        @Query("collection_name")
//        collectionName: String = "sections"
//    ): Response<SectionsCollection>

    @GET("get_data/")
    suspend fun getCategories(
        @Query("collection_name")
        collectionName: String = "tests"
    ): Response<ServerResponseMusicTest>

    // POST request
}
