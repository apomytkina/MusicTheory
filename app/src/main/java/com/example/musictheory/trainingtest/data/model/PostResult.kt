package com.example.musictheory.trainingtest.data.model

import com.google.gson.annotations.SerializedName

data class PostResult(
    @SerializedName("collection_name")
    val collectionName: String,

    @SerializedName("data")
    val data: List<PostResult>

)
