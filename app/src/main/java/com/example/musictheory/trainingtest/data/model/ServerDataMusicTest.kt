package com.example.musictheory.trainingtest.data.model

import com.google.gson.annotations.SerializedName

/**
 * @author Владислав Хвесюк 08.11.2021
 */

data class ServerDataMusicTest(
    @SerializedName("collection_name")
    val collectionName: String,
    val collection: List<MusicTest>
)
