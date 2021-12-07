package com.example.musictheory.account.student.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PersonalAccountViewModel : ViewModel() {
    private val _goRegister = MutableStateFlow<Boolean>(false)
    val goRegister: StateFlow<Boolean> = _goRegister.asStateFlow()
    fun setRegister(boolean: Boolean) {
        _goRegister.value = boolean
    }
}
