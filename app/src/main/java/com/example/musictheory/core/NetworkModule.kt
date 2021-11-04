package com.example.musictheory.core

import com.example.musictheory.BuildConfig
import com.example.musictheory.core.data.api.ApiHelperImpl
import com.example.musictheory.core.data.api.MusicEducationApiService
import com.example.musictheory.core.domain.api.ApiHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Владислав Хвесюк 02.11.2021
 *
 * Модуль DI для поставки retrofit клиента и api к нему
 */
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule @Inject constructor() {

    @Provides
    fun provideBaseURL() = BuildConfig.BASE_URL

    @Provides
    @Singleton
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else OkHttpClient
        .Builder()
        .build()

    /** @param url это BASE_URL
     *
     */
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, url: String): Retrofit =
        Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideMusicEducationApiService(
        retrofit: Retrofit
    ): MusicEducationApiService = retrofit.create(
        MusicEducationApiService::class.java
    )

    @Provides
    @Singleton
    fun provideApiHelper(
        musicEducationApiService: MusicEducationApiService
    ): ApiHelper = ApiHelperImpl(musicEducationApiService)
}
