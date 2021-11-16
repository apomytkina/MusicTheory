package com.example.musictheory

import android.app.Application
import com.example.ExecutorBuildType
import dagger.hilt.android.HiltAndroidApp

/**
 * @author Владислав Хвесюк 19.10.2021
 *
 * Timber подключен через [ExecutorBuildType]
 */
@HiltAndroidApp
class MainApplication : Application() {
    override fun onCreate() {
        ExecutorBuildType.execute()
        super.onCreate()
    }
}
