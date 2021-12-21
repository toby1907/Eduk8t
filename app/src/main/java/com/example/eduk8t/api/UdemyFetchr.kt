package com.example.eduk8t.api

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val TAG ="UdemyFetchr"
class UdemyFetchr {
    private val udemyApi: UdemyApi
    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://www.udemy.com/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
        udemyApi=retrofit.create(UdemyApi::class.java)
    }
    fun fetchContents(): MutableLiveData<String> {
        val responseLiveData: MutableLiveData<String> = MutableLiveData()
        val udemyRequest: Call<String> = udemyApi.fetchContents()
        udemyRequest.enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.e(TAG, "Failed to fetch photos", t)
            }
            override fun onResponse(
                call: Call<String>,
                response: Response<String>
            ) {
                Log.d(TAG, "Response received")
                responseLiveData.value = response.body()
            }
        })
        return responseLiveData
    }

}