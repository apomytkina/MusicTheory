package com.example.musictheory.home.homeViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musictheory.home.homeRepository.CategoriesRepository
import com.example.musictheory.trainingtest.data.model.MusicTest
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch
import timber.log.Timber

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: CategoriesRepository
) : ViewModel() {

    private val _categories = MutableLiveData<List<MusicTest>>()
    val categories: LiveData<List<MusicTest>> = _categories

    private fun getCategories() = viewModelScope.launch {
        repository.getCategories().let { response ->
            Timber.v("t1 ${response.body()}")
            val responseCollection = response.body()
            if (response.isSuccessful && responseCollection != null)
                _categories.postValue(responseCollection.data.collection)
            else
                Log.d(
                    "tag",
                    "getCategories Error: ${response.code()}"
                )
        }
    }

    init {
        getCategories()
    }
}
