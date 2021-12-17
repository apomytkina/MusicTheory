package com.example.musictheory.core.domain.repository

import com.example.musictheory.account.data.model.PostDeleteTest
import com.example.musictheory.account.data.model.PostLogin
import com.example.musictheory.account.data.model.PostMusicTest
import com.example.musictheory.account.data.model.PostSignUp
import com.example.musictheory.account.data.model.ResponseLogin
import com.example.musictheory.core.data.model.ServerResponse
import com.example.musictheory.home.homeModel.PostSection
import com.example.musictheory.home.homeModel.SectionsCollection
import com.example.musictheory.trainingtest.data.model.PostResult
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

    suspend fun postResult(
        postResult: PostResult
    ): Call<PostResult>

    suspend fun postDeleteTest(
        postDeleteTest: PostDeleteTest
    ): Call<PostDeleteTest>

    suspend fun postSignUp(
        postSignUp: PostSignUp
    ): Call<ResponseLogin>

    suspend fun postLogin(
        postLogin: PostLogin
    ): Call<ResponseLogin>
}
