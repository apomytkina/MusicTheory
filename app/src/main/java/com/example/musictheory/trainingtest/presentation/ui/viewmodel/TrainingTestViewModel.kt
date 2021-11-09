package com.example.musictheory.trainingtest.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.musictheory.core.data.model.ServerResponse
import com.example.musictheory.trainingtest.domain.usecases.TrainingTestInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
class TrainingTestViewModel @Inject constructor() :
    ViewModel() {
    /**
     * Интерактор для взаимодействия с репозиторием
     *
     * Провайдер указан в InteractorModule
     *
     * @see com.example.musictheory.core.modules.InteractorModule
     */
    @Inject
    lateinit var trainingTestInteractor: TrainingTestInteractor

    private val _messageHello = MutableStateFlow("Фрагмент тренировочных тестов")
    val messageHello: StateFlow<String> = _messageHello.asStateFlow()

    private val _questionString = MutableStateFlow("Вопрос")
    val questionString: StateFlow<String> = _questionString.asStateFlow()

//    private val _questionString = MutableSharedFlow<String>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
//    val questionString: SharedFlow<String> = _questionString.asSharedFlow()

    private val _answersList = MutableStateFlow<List<String>>(mutableListOf("10", "20"))
    val answersList: StateFlow<List<String>> = _answersList.asStateFlow()

    /**
     * Получаем данные через интерактор
     *
     * @return Пока что возвращает только тесты, нужно либо обобщить его,
     *
     * либо сделать еще методы
     */
    suspend fun getTests(): ServerResponse {
        return trainingTestInteractor.getTests()
    }

    suspend fun postTest() {
        trainingTestInteractor.postTest()
    }

    suspend fun getData(serverResponse: ServerResponse) {
        // UI почему-то получаем данные только в родительском фрагменте
        _answersList.value = serverResponse.data.collection[0].answerArray
        _questionString.emit(serverResponse.data.collection[0].questionArray[0])
    }
}
