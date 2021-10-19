package com.example.musictheory.trainingtest.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.*

class TrainingTestViewModel : ViewModel() {
    private val _messageHello = MutableStateFlow<String>("Фрагмент тренировочных тестов")
    val messageHello : StateFlow<String> = _messageHello.asStateFlow()

}