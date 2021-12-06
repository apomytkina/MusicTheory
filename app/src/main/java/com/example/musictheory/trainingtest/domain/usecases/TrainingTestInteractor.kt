package com.example.musictheory.trainingtest.domain.usecases

import com.example.musictheory.core.domain.repository.MainRepository
import com.example.musictheory.core.domain.usecases.MainInteractor
import com.example.musictheory.home.homeModel.Collection
import com.example.musictheory.home.homeModel.Id
import com.example.musictheory.home.homeModel.PostSection
import com.example.musictheory.trainingtest.data.model.MusicTest
import com.example.musictheory.trainingtest.data.model.PostMusicTest
import com.example.musictheory.trainingtest.data.model.ServerResponseMusicTest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @author Владислав Хвесюк  08.11.2021
 */
class TrainingTestInteractor(
    private val mainRepository: MainRepository
) : MainInteractor {
    suspend fun getTests(): ServerResponseMusicTest = withContext(Dispatchers.IO) {
        return@withContext mainRepository.getMusicTest("tests")
            .execute().body() ?: error("not found")
    }

    suspend fun postTest() = withContext(Dispatchers.IO) {
        mainRepository.postTest(
            PostMusicTest(
                "tests",
                listOf(
                    MusicTest(
                        Id("1"),
                        "1",
                        listOf("Какие знаки в ля мажоре", "Сколько знаков в ля мажоре"),
                        listOf(
                            listOf("диезы", "бемоли"),
                            listOf("3", "0", "1", "2", "4", "5", "6", "7")
                        ),
                        listOf("none", "stave")
                    )
                )
            )
        )
            .execute()
    }

    suspend fun postCollection() = withContext(Dispatchers.IO) {
        mainRepository.postSection(
            PostSection(
                listOf(
                    Collection(
                        Id("1"),
                        "",
                        "Тест на тональности"
                    )
                ),
                "sections"
            )
        )
            .execute()
    }
}
