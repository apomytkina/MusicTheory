package com.example.musictheory.account.LoginScreen.viewmodel

import androidx.lifecycle.ViewModel
import com.example.musictheory.account.LoginScreen.PersonalAccountFragments
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PersonalAccountViewModel : ViewModel() {
    private val _goRegister = MutableStateFlow<PersonalAccountFragments>(PersonalAccountFragments.NONE)
    val goRegister: StateFlow<PersonalAccountFragments> = _goRegister.asStateFlow()
    fun setRegister(fragment : PersonalAccountFragments) {
        _goRegister.value = fragment
    }
}
