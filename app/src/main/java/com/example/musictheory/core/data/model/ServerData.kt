package com.example.musictheory.core.data.model

import com.google.gson.annotations.SerializedName

/**
 * @author Владислав Хвесюк 02.11.2021
 */
data class ServerData(
    /**
     * Пока что данные в виде String
     */
    @SerializedName("data")
    val data: String
)
