package com.example.musictheory.trainingtest.presentation.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musictheory.data.Repository
import com.example.musictheory.model.Result
import com.example.musictheory.model.Test
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

    private val _test: MutableLiveData<Test> = MutableLiveData()
    val test: LiveData<Test>
        get() = _test

    fun saveResult(result: Result) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.local.saveResult(result)
        }
    }

    fun saveTest(test: Test) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.local.saveTest(test)
        }
    }

    fun getResultById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.local.getResultById(id).collect { results ->
                _result.postValue(results[0])
            }
        }
    }

    fun getTestById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.local.getTestById(id).collect { tests ->
                _test.postValue(tests[0])
            }
        }
    }
}