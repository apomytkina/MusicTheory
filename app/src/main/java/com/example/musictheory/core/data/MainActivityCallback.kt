package com.example.musictheory.core.data

/**
 * @author Владислав Хвесюк 26.10.2021
 */

interface MainActivityCallback {
    fun hideBottomNavigationView()
    fun showBottomNavigationView()
    fun goTestFragment(position: String)
    fun goResultFragment(id: Long)
    fun checkDarkMode()
}
