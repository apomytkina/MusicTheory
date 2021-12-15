package com.example.musictheory.account.data.model

import com.google.gson.annotations.SerializedName

data class ResponseLogin(
    @SerializedName("result")
    val result: String,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("role")
    val role: String = "",
    @SerializedName("data")
    val data: String = "",
    @SerializedName("errotest")
    val error: String = ""
)
