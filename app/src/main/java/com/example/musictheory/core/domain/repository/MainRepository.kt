package com.example.musictheory.core.domain.repository
import com.example.musictheory.core.data.model.ServerData
import com.example.musictheory.core.data.model.ServerResponse
import com.example.musictheory.trainingtest.data.model.PostMusicTest
import retrofit2.Call

/**
 * @author Владислав Хвесюк 07.11.2021
 */

interface MainRepository {
    /**
     * Пока возвращает только tests, потому что требуется обобщение класса ServerResponse,
     *
     * либо создание еще классов
     */
    suspend fun getCollectionByName(collectionName: String): Call<ServerResponse>

    suspend fun postSection(
        serverData: ServerData
    ): Call<ServerData>

    suspend fun postTest(
        postMusicTest: PostMusicTest
    ): Call<PostMusicTest>
}
