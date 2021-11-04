package com.example.musictheory.trainingtest.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.musictheory.core.data.model.ServerData
import com.example.musictheory.core.data.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.withContext

@HiltViewModel
class TrainingTestViewModel @Inject constructor(private val mainRepository: MainRepository) :
    ViewModel() {
    private val _messageHello = MutableStateFlow("Фрагмент тренировочных тестов")
    val messageHello: StateFlow<String> = _messageHello.asStateFlow()

    /**
     * Пока что получаем данные с сервера подобным образом
     *
     * Либо через DataStoreMusicEducation
     *
     * @see com.example.musictheory.core.data.DataStoreMusicEducation
     */
    suspend fun getSections(): ServerData = withContext(Dispatchers.IO) {
        return@withContext mainRepository.getCollectionByName("sections")
            .execute().body() ?: error("not found")
    }
}
