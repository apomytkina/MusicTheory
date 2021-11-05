package com.example.musictheory.data

import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class Repository @Inject constructor(
    localDataSource: LocalDataSource
) {
    val local = localDataSource
}