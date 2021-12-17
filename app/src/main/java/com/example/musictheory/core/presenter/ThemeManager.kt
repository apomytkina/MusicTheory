package com.example.musictheory.core.presenter

import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.appcompat.app.AppCompatDelegate.setDefaultNightMode

object ThemeManager {

    const val LIGHT_MODE = "Light"
    const val DARK_MODE = "Dark"
    private const val AUTO_BATTERY_MODE = "Auto-battery"
    private const val FOLLOW_SYSTEM_MODE = "System"

    fun applyTheme(themePreference: String) {
        when (themePreference) {
            LIGHT_MODE -> setDefaultNightMode(MODE_NIGHT_NO)
            DARK_MODE -> setDefaultNightMode(MODE_NIGHT_YES)
            AUTO_BATTERY_MODE -> setDefaultNightMode(MODE_NIGHT_AUTO_BATTERY)
            FOLLOW_SYSTEM_MODE -> setDefaultNightMode(MODE_NIGHT_FOLLOW_SYSTEM)
        }
    }
}
