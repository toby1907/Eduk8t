package com.example.eduk8t.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.eduk8t.api.UdemyFetchr

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val _udemyfetchr = MutableLiveData<String>().apply {
        value = UdemyFetchr().fetchContents().toString()

    }

    val udemyFetchr: LiveData<String> =_udemyfetchr






   private val _udemyLiveData:LiveData<String> = Transformations.map(UdemyFetchr().fetchContents(),{
        it
    })
    val udemyLiveData: LiveData<String> = _udemyLiveData
}


