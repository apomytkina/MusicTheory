package com.example.musictheory.home.homeModel

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("collection")
    val collection: List<Collection>,
    @SerializedName("collection_name")
    val collectionName: String
)
