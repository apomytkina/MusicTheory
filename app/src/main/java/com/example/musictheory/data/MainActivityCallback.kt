package com.example.musictheory.data

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn

/**
 * @author Владислав Хвесюк 26.10.2021
 */

@EntryPoint
@InstallIn
interface MainActivityCallback {
    fun hideBottomNavigationView()
    fun showBottomNavigationView()
}