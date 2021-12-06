package com.example.musictheory.home.homeRepository

import com.example.musictheory.home.homeApi.RetrofitInstance
import javax.inject.Inject

class CategoriesRepository @Inject constructor() {
    suspend fun getCategories() = RetrofitInstance.api.getCategories()
}
