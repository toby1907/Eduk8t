package com.example.eduk8t.ui.home

import androidx.lifecycle.*
import com.example.eduk8t.api.UdemyApi
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>()
    val text: LiveData<String> = _text
    init {
        getUdemyContents()
    }



    private fun getUdemyContents() {
        viewModelScope.launch {
            val listResult = UdemyApi.retrofitService.fetchContents()
            _text.value = listResult
        }
    }
}




