package com.example.musictheory.core.data.model

import com.google.gson.annotations.SerializedName

/**
 * @author Владислав Хвесюк 02.11.2021
 *
 * Не используется. Каждый пишет свои модель в своей папке
 */
data class ServerResponse(
    @SerializedName("data")
    val data: ServerData
)
