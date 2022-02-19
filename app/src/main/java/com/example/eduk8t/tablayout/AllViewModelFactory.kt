package com.example.eduk8t.tablayout

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class HomeViewModelFactory(val app: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AllViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AllViewModel( app) as T
        }
        throw IllegalArgumentException("Unable to construct viewmodel")
    }
}