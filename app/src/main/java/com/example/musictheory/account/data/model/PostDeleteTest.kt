package com.example.musictheory.account.data.model

import com.google.gson.annotations.SerializedName

data class PostDeleteTest(
    @SerializedName("collection_name")
    val collectionName: String,
    @SerializedName("filter")
    val filter: String,
    @SerializedName("values")
    val values: List<String>
)
