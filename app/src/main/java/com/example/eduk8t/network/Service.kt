package com.example.eduk8t.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val TAG ="UdemyFetchr"
private const val BASE_URL = "https://www.udemy.com/api-2.0/"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

    //MarsApiService defines how Retrofit talks to the web server using HTTP requests.
    interface UdemyApiService {
        //  to get the response string from the web service
//    when the getPhotos() is invoked, retrofit appends the photos to the base Url(which you defined in the retrofit builder)
//used to start the request.
        @GET("courses")
        suspend fun fetchContents(): String
    }

    object UdemyApi{
        //    Each time app calls MarsApi.retrofitService, the caller will access the same singleton Retrofit object that
//    implements MarsApiService which is created on the first access
        val  retrofitService : UdemyApiService by lazy {
            retrofit.create(UdemyApiService::class.java)
        }

}


/*
private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

//MarsApiService defines how Retrofit talks to the web server using HTTP requests.
interface MarsApiService{
    //  to get the response string from the web service
//    when the getPhotos() is invoked, retrofit appends the photos to the base Url(which you defined in the retrofit builder)
//used to start the request.
    @GET("photos")
    suspend fun getPhotos(): String
}

object MarsApi{
    //    Each time app calls MarsApi.retrofitService, the caller will access the same singleton Retrofit object that
//    implements MarsApiService which is created on the first access
    val  retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}*/
