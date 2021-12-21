package com.example.eduk8t.api

import retrofit2.Call
import retrofit2.http.GET

interface UdemyApi {
    @GET("/")
    fun fetchContents(): Call<String>
}