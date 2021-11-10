package com.example.musictheory.trainingtest.data.model

import com.google.gson.annotations.SerializedName

/**
 * @author Владислав Хвесюк 02.11.2021
 */
data class MusicTest(
    @SerializedName("sections_id")
    val sectionsId: String,
    @SerializedName("question_array")
    val questionArray: List<String>,
    @SerializedName("answer_array")
    val answerArray: List<String>,
    @SerializedName("dislpayed_elemets")
    val displayedElements: List<String>
)
