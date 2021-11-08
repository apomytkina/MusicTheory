package com.example.musictheory.home.home_viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _categories = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val categories: LiveData<String> = _categories

    fun getCategories() = viewModelScope.launch {
    }

    init {
        getCategories()
    }
}
