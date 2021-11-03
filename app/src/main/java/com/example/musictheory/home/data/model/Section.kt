package com.example.musictheory.home.data.model

import com.google.gson.annotations.SerializedName

/**
 * @author Владислав Хвесюк 02.11.2021
 *
 * Для получения данных пока используем класс ServerData
 *
 * @see com.example.musictheory.core.data.model.ServerData
 */

data class Section(
    @SerializedName("name")
    val name: String,
    @SerializedName("img_src")
    val imgSrc: String
)
