package com.example.musictheory.core.modules

import com.example.musictheory.BuildConfig
import com.example.musictheory.core.data.api.ApiHelperImpl
import com.example.musictheory.core.data.api.MusicEducationApiService
import com.example.musictheory.core.data.repositories.DataStoreMusicEducation
import com.example.musictheory.core.data.repositories.MainRepositoryImpl
import com.example.musictheory.core.domain.api.ApiHelper
import com.example.musictheory.core.domain.repository.MainRepository
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

    /**
     * Так понимаю, три метода ниже лучше заменить @Provide на @Bind?
     */
    @Provides
    @Singleton
    fun provideApiHelper(
        musicEducationApiService: MusicEducationApiService
    ): ApiHelper = ApiHelperImpl(musicEducationApiService)

    @Provides
    @Singleton
    fun provideMainRepository(
        apiHelper: ApiHelper
    ): MainRepository = MainRepositoryImpl(apiHelper)

    @Provides
    @Singleton
    fun provideDataStoreMusicEducation(
        mainRepository: MainRepository
    ): DataStoreMusicEducation = DataStoreMusicEducation(mainRepository)
}
