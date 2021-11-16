package com.example.musictheory.trainingtest.domain.usecases

import com.example.musictheory.core.data.model.ServerResponse
import com.example.musictheory.core.domain.repository.MainRepository
import com.example.musictheory.core.domain.usecases.MainInteractor
import com.example.musictheory.trainingtest.data.model.MusicTest
import com.example.musictheory.trainingtest.data.model.PostMusicTest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @author Владислав Хвесюк  08.11.2021
 */
class TrainingTestInteractor(
    private val mainRepository: MainRepository
) : MainInteractor {
    suspend fun getTests(): ServerResponse = withContext(Dispatchers.IO) {
        return@withContext mainRepository.getCollectionByName("tests")
            .execute().body() ?: error("not found")
    }

    suspend fun postTest() = withContext(Dispatchers.IO) {
        mainRepository.postTest(
            PostMusicTest(
                "tests",
                listOf(
                    MusicTest(
                        "4",
                        listOf("question4"),
                        listOf("answer4"),
                        listOf("displayed4")
                    )
                )
            )
        )
            .execute()
    }
}
