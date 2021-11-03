package com.example.musictheory.core.data.api

import com.example.musictheory.core.data.model.ServerData
import com.example.musictheory.core.domain.api.ApiHelper
import com.example.musictheory.home.data.model.PostSection
import com.example.musictheory.trainingtest.data.model.PostMusicTest
import retrofit2.Call

/**
 * @author Владислав Хвесюк 02.11.2021
 */

class ApiHelperImpl(private val apiService: MusicEducationApiService) : ApiHelper {
    override suspend fun getCollectionByName(collectionName: String): Call<ServerData> {
        return apiService.getCollectionByName("tests")
    }

    override suspend fun postSection(postSection: PostSection): Call<PostSection> {
        return apiService.postSection(postSection)
    }

    override suspend fun postTest(postMusicTest: PostMusicTest): Call<PostMusicTest> {
        return apiService.postTest(postMusicTest)
    }
}
