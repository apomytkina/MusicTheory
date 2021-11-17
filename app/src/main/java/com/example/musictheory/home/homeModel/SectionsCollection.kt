package com.example.musictheory.home.homeModel

import com.google.gson.annotations.SerializedName

data class SectionsCollection(
    @SerializedName("data")
    val data: Data,
    @SerializedName("result")
    val result: String
)
