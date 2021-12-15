package com.example.musictheory.account.data.model

import com.google.gson.annotations.SerializedName

data class MusicTestWithoutId(
    @SerializedName("sections_id")
    val sectionsId: String,
    @SerializedName("question_array")
    val questionArray: List<String>,
    @SerializedName("answer_array")
    val answerArray: List<List<String>>,
    @SerializedName("dislpayed_elemets")
    val displayedElements: List<String>,
    @SerializedName("test_name")
    val testName: String
)
