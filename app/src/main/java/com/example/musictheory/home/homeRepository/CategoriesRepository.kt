package com.example.musictheory.home.homeRepository

import com.example.musictheory.home.homeApi.RetrofitInstance

class CategoriesRepository {
    suspend fun getCategories() = RetrofitInstance.api.getCategories()
}
