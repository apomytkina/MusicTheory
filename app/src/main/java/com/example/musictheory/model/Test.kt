package com.example.musictheory.model

data class Test(
    val id: Int,
    val idCategory: Int,
    val questions: List<String>,
    val answers: List<String>,
    val typeOfQuestion: TypeQuestion
)

enum class TypeQuestion {
    SIMPLE, HARD
}