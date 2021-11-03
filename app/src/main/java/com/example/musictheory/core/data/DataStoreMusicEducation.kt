package com.example.musictheory.core.data

import com.example.musictheory.core.data.model.ServerData
import com.example.musictheory.core.data.repositories.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Владислав Хвесюк 02.11.2021
 */

// Временное решение
@Singleton
class DataStoreMusicEducation @Inject constructor(
    private val mainRepository: MainRepository
) {
    suspend fun getSections(): ServerData = withContext(Dispatchers.IO) {
        return@withContext mainRepository.getCollectionByName("sections")
            .execute().body() ?: error("not found")
    }

    suspend fun getTests(): ServerData = withContext(Dispatchers.IO) {
        return@withContext mainRepository.getCollectionByName("tests")
            .execute().body() ?: error("not found")
    }

    // Код ниже можно использовать, но проверку он не проходит. Пока ждем исправлений со стороны сервера

//    /**
//     * Запросы post выполняются, но там ответы не в формате json, а в html/text, поэтому крашится.
//     *
//     * Скоро поправят, поэтому не стал отключать проверку ответа в приложении
//     */
//    suspend fun postSection() = withContext(Dispatchers.IO) {
//        try {
//            mainRepository.postSection(
//                PostSection("sections", listOf(Section("section8", "not")))
//            ).execute()
//        } catch (e: Exception) {
//            Timber.v(e)
//        }
//    }
//
//    /**
//     * Запросы post выполняются, но там ответы не в формате json, а в html/text, поэтому крашится.
//     *
//     * Скоро поправят, поэтому не стал отключать проверку ответа в приложении
//     */
//    suspend fun postTest() = withContext(Dispatchers.IO) {
//        try {
//            mainRepository.postTest(
//                PostMusicTest(
//                    "tests",
//                    listOf(
//                        MusicTest(
//                            "123",
//                            listOf("question1"),
//                            listOf("answer1"),
//                            listOf("displayed1")
//                        )
//                    )
//                )
//            )
//                .execute()
//        } catch (e: Exception) {
//            Timber.v(e)
//        }
//    }
}
