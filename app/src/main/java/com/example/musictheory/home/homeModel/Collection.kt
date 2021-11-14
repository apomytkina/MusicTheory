package com.example.musictheory.home.homeModel

import com.google.gson.annotations.SerializedName

data class Collection(
    @SerializedName("_id")
    val id: Id,
    val img_src: String,
    val name: String
)
