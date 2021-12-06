package com.example.musictheory.core.data.api

import com.example.musictheory.core.data.model.ServerResponse
import com.example.musictheory.home.homeModel.PostSection
import com.example.musictheory.home.homeModel.SectionsCollection
import com.example.musictheory.trainingtest.data.model.PostMusicTest
import com.example.musictheory.trainingtest.data.model.ServerResponseMusicTest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * @author Владислав Хвесюк 02.11.2021
 */

interface MusicEducationApiService {
    @GET("get_data")
    fun getCollectionByName(
        @Query("collection_name") collectionName: String
    ): Call<ServerResponse>

    @GET("get_data")
    fun getMusicTest(
        @Query("collection_name") collectionName: String
    ): Call<ServerResponseMusicTest>

    @POST("put_data/")
    fun postSection(@Body serverData: PostSection): Call<SectionsCollection>

    @POST("put_data/")
    fun postTest(@Body postMusicTest: PostMusicTest): Call<PostMusicTest>
}
