package com.example.eduk8t.ui.home

import androidx.lifecycle.*

import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>()
    val text: LiveData<String> = _text
    init {
        getUdemyContents()
    }



    private fun getUdemyContents() {
        viewModelScope.launch {

        }
    }
}




