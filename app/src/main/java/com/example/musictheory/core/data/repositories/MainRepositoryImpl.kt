package com.example.musictheory.core.data.repositories

import com.example.musictheory.core.domain.api.ApiHelper
import com.example.musictheory.core.domain.repository.MainRepository
import com.example.musictheory.home.homeModel.PostSection
import com.example.musictheory.trainingtest.data.model.PostMusicTest
import retrofit2.Call

/**
 * @author Владислав Хвесюк 02.11.2021
 *
 * Пока работаем через данный класс
 */
class MainRepositoryImpl(
    private val apiHelper: ApiHelper
) : MainRepository {
    override suspend fun getCollectionByName(
        collectionName: String
    ) = apiHelper.getCollectionByName(collectionName)

    override suspend fun getMusicTest(
        collectionName: String
    ) = apiHelper.getMusicTest(collectionName)

    override suspend fun postSection(
        serverData: PostSection
    ) = apiHelper.postSection(serverData)

    override suspend fun postTest(
        postMusicTest: PostMusicTest
    ): Call<PostMusicTest> = apiHelper.postTest(postMusicTest)
}
