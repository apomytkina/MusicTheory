package com.example.musictheory.core.data.model

import com.example.musictheory.trainingtest.data.model.MusicTest
import com.google.gson.annotations.SerializedName

/**
 * @author Владислав Хвесюк 08.11.2021
 *
 * Не используется. Каждый пишет свои модель в своей папке
 */

data class ServerData(
    @SerializedName("collection_name")
    val collectionName: String,
    val collection: List<MusicTest>
)
