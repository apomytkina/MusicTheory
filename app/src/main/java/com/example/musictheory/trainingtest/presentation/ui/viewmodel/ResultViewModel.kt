package com.example.musictheory.trainingtest.presentation.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musictheory.data.Repository
import com.example.musictheory.model.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {

    private val _result: MutableLiveData<Result> = MutableLiveData()
    val result: LiveData<Result>
        get() = _result

    fun saveResult(result: Result) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.local.saveResult(result)
        }
    }

    fun getResultById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.local.getResultById(id).collect { results ->
                _result.postValue(results[0])
            }
        }
    }
}