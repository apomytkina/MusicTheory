package com.example.musictheory.core.data.repositories

import com.example.musictheory.core.domain.api.ApiHelper
import com.example.musictheory.home.data.model.PostSection
import com.example.musictheory.trainingtest.data.model.PostMusicTest
import javax.inject.Inject

/**
 * @author Владислав Хвесюк 02.11.2021
 *
 * Пока работаем через данный класс
 */
class MainRepository @Inject constructor(
    private val apiHelper: ApiHelper
) {
    suspend fun getCollectionByName(
        collectionName: String
    ) = apiHelper.getCollectionByName(collectionName)

    suspend fun postSection(
        postSection: PostSection
    ) = apiHelper.postSection(postSection)

    suspend fun postTest(
        postMusicTest: PostMusicTest
    ) = apiHelper.postTest(postMusicTest)
}
