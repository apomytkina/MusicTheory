package com.example.musictheory.home.home_repository

import com.example.musictheory.home.home_api.RetrofitInstance.Companion.api

class CategoriesRepository {
    suspend fun getCategories() = api.getCategories()
}
