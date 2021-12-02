package com.example.musictheory.core.domain.repository
import com.example.musictheory.core.data.model.ServerResponse
import com.example.musictheory.home.homeModel.PostSection
import com.example.musictheory.home.homeModel.SectionsCollection
import com.example.musictheory.trainingtest.data.model.PostMusicTest
import com.example.musictheory.trainingtest.data.model.ServerResponseMusicTest
import retrofit2.Call

/**
 * @author Владислав Хвесюк 07.11.2021
 */

interface MainRepository {
    suspend fun getCollectionByName(collectionName: String): Call<ServerResponse>

    suspend fun getMusicTest(collectionName: String): Call<ServerResponseMusicTest>

    suspend fun postSection(
        serverData: PostSection
    ): Call<SectionsCollection>

    suspend fun postTest(
        postMusicTest: PostMusicTest
    ): Call<PostMusicTest>
}
