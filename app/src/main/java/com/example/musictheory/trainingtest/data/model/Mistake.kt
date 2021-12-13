package com.example.musictheory.trainingtest.data.model

import com.google.gson.annotations.SerializedName

data class Mistake(
    @SerializedName("answer")
    val answer: String,
    val question:String
)