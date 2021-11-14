package com.example.musictheory.home.homeRepository

import com.example.musictheory.home.homeApi.RetrofitInstance.Companion.api

class CategoriesRepository {
    suspend fun getCategories() = api.getCategories()
}
