package com.example.musictheory.account.data.model

import com.google.gson.annotations.SerializedName

data class PostSignUp(
    @SerializedName("token")
    val token: String,
    @SerializedName("role")
    val role: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("data")
    val data: String,
    @SerializedName("pass")
    val pass: String
)
