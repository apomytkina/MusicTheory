package com.example.musictheory.home.homeViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musictheory.home.homeModel.Collection
import com.example.musictheory.home.homeRepository.CategoriesRepository
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: CategoriesRepository
) : ViewModel() {

    private val _categories = MutableLiveData<List<Collection>>()
    val categories: LiveData<List<Collection>> = _categories

    private fun getCategories() = viewModelScope.launch {
        repository.getCategories().let { response ->
            val responseCollection = response.body()
            if (response.isSuccessful && responseCollection != null)
                _categories.postValue(responseCollection.data.collection)
            else
                Log.d("tag", "getCategories Error: ${response.code()}")
        }
    }

    init {
        getCategories()
    }
}
