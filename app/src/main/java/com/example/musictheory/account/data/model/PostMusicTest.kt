package com.example.musictheory.account.data.model

import com.google.gson.annotations.SerializedName

/**
 * @author Владислав Хвесюк 02.11.2021
 */

data class PostMusicTest(
    @SerializedName("collection_name")
    val collectionName: String,
    /**
     * Отправляем данные в виде списка
     */
    @SerializedName("data")
    val data: List<MusicTestWithoutId>
)
