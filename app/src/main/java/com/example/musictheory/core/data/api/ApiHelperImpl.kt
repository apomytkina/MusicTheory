package com.example.musictheory.core.data.api

import com.example.musictheory.core.data.model.ServerData
import com.example.musictheory.core.data.model.ServerResponse
import com.example.musictheory.core.domain.api.ApiHelper
import com.example.musictheory.trainingtest.data.model.PostMusicTest
import com.example.musictheory.trainingtest.data.model.ServerResponseMusicTest
import retrofit2.Call

/**
 * @author Владислав Хвесюк 02.11.2021
 */

class ApiHelperImpl(private val apiService: MusicEducationApiService) : ApiHelper {
    override suspend fun getCollectionByName(collectionName: String): Call<ServerResponse> {
        return apiService.getCollectionByName("tests")
    }

    override suspend fun getMusicTest(collectionName: String): Call<ServerResponseMusicTest> {
        return apiService.getMusicTest("tests")
    }

    override suspend fun postSection(serverData: ServerData): Call<ServerData> {
        return apiService.postSection(serverData)
    }

    override suspend fun postTest(postMusicTest: PostMusicTest): Call<PostMusicTest> {
        return apiService.postTest(postMusicTest)
    }
}
