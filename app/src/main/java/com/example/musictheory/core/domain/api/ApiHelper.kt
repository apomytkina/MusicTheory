package com.example.musictheory.core.domain.api

import com.example.musictheory.core.data.model.ServerData
import com.example.musictheory.core.data.model.ServerResponse
import com.example.musictheory.trainingtest.data.model.PostMusicTest
import retrofit2.Call

/**
 * @author Владислав Хвесюк 02.11.2021
 */

interface ApiHelper {
    suspend fun getCollectionByName(collectionName: String): Call<ServerResponse>

    suspend fun postSection(serverData: ServerData): Call<ServerData>

    suspend fun postTest(postMusicTest: PostMusicTest): Call<PostMusicTest>
}
