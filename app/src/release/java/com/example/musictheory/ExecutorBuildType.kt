package com.example.musictheory

import okhttp3.OkHttpClient
object ExecutorBuildType {
    fun execute() {
        return
    }
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .build()
    }
}
