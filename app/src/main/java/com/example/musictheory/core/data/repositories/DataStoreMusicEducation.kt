package com.example.musictheory.core.data.repositories

import com.example.musictheory.core.data.model.ServerResponse
import com.example.musictheory.core.domain.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @author Владислав Хвесюк 02.11.2021
 *
 * Вариант на всякий случай. Лучше обращаться через интеракторы,
 *
 * как это реализовано в [TrainingTestViewModel]
 *
 * Нигде не используется
 *
 * @see com.example.musictheory.trainingtest.presentation.ui.viewmodel.TrainingTestViewModel

 */

// Временное решение
class DataStoreMusicEducation(private val mainRepository: MainRepository) {
    suspend fun getSections(): ServerResponse = withContext(Dispatchers.IO) {
        return@withContext mainRepository.getCollectionByName("sections")
            .execute().body() ?: error("not found")
    }

    suspend fun getTests(): ServerResponse = withContext(Dispatchers.IO) {
        return@withContext mainRepository.getCollectionByName("tests")
            .execute().body() ?: error("not found")
    }

//     Код ниже можно использовать, но проверку он не проходит. Пока ждем исправлений со стороны сервера

//    suspend fun postSection() = withContext(Dispatchers.IO) {
//        try {
//            mainRepository.postSection(
//                ServerData("sections", listOf(Section("section8", "not")))
//            ).execute()
//        } catch (e: Exception) {
//            Timber.v(e)
//        }
//    }

//    suspend fun postTest() = withContext(Dispatchers.IO) {
//        mainRepository.postTest(
//            PostMusicTest(
//                "tests",
//                listOf(
//                    MusicTest(
//                        "123",
//                        listOf("question1"),
//                        listOf("answer1"),
//                        listOf("displayed1")
//                    )
//                )
//            )
//        )
//            .execute()
//    }
}
