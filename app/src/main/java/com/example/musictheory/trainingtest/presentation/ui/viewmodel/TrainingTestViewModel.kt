package com.example.musictheory.trainingtest.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.musictheory.trainingtest.data.model.MusicTest
import com.example.musictheory.trainingtest.data.model.ServerResponseMusicTest
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

    private val _serverResponseCollection = MutableStateFlow<MusicTest>(
        MusicTest("", listOf(), listOf(), listOf())
    )

    private val _questionString = MutableStateFlow("Вопрос")
    val questionString: StateFlow<String> = _questionString.asStateFlow()

    private val _answersList = MutableStateFlow<List<String>>(
        mutableListOf("10", "20", "30", "40", "50", "60", "70")
    )
    val answersList: StateFlow<List<String>> = _answersList.asStateFlow()

    private val _displayedElements = MutableStateFlow("none")
    val displayedElements: StateFlow<String> = _displayedElements.asStateFlow()

    private val _goNextEvent = MutableStateFlow<Boolean>(false)
    val goNextEvent: StateFlow<Boolean> = _goNextEvent.asStateFlow()

    private val _currentQuestionNum = MutableStateFlow(0)
    val currentQuestionNum: StateFlow<Int> = _currentQuestionNum.asStateFlow()

    private val _currentRightAnswer = MutableStateFlow("")
    val currentRightAnswer: StateFlow<String> = _currentRightAnswer.asStateFlow()

    /**
     * Получаем данные через интерактор
     */
    suspend fun getTests(): ServerResponseMusicTest {
        return trainingTestInteractor.getTests()
    }

    suspend fun postTest() {
        trainingTestInteractor.postTest()
    }

    fun getData(serverResponse: ServerResponseMusicTest) {
        _serverResponseCollection.value = serverResponse.data.collection[0]
        _currentRightAnswer.value = _serverResponseCollection.value.answerArray[_currentQuestionNum.value][0]
        _answersList.value = _serverResponseCollection.value.answerArray[_currentQuestionNum.value].shuffled()
        _questionString.value = _serverResponseCollection.value.questionArray[_currentQuestionNum.value]

//        _answersList.value = serverResponse.data.collection[0].answerArray[0]
//        _questionString.emit(serverResponse.data.collection[0].questionArray[0])
    }

    fun goNext() {
        _currentQuestionNum.value = _currentQuestionNum.value + 1
        if (_currentQuestionNum.value > _serverResponseCollection.value.questionArray.size) {
            return
        } else {
            _answersList.value = _serverResponseCollection.value.answerArray[_currentQuestionNum.value]
            _questionString.value = _serverResponseCollection.value.questionArray[_currentQuestionNum.value]
            _goNextEvent.value = true
        }
    }
}
