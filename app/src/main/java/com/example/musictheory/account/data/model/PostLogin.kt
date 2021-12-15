package com.example.musictheory.account.data.model

import com.google.gson.annotations.SerializedName

data class PostLogin(
    @SerializedName("token")
    val token: String
)
