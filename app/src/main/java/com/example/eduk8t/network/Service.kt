package com.example.eduk8t.network

import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val TAG ="UdemyFetchr"
private const val BASE_URL = "https://www.udemy.com/api-2.0/"

private val client = OkHttpClient.Builder().apply {
    addInterceptor(MyInterceptor())
}.build()

private val moshi = Moshi.Builder()
    .add(com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .client(client)
    .baseUrl(BASE_URL)
    .build()

    //MarsApiService defines how Retrofit talks to the web server using HTTP requests.

        //  to get the response string from the web service
//    when the getPhotos() is invoked, retrofit appends the photos to the base Url(which you defined in the retrofit builder)
//used to start the request.
        interface UdemyApiService {
            @GET("courses")
            suspend fun getCourses(): UdemyApiResponse

            @GET("courses")
            suspend fun searchCourses(
                @Query("search") searchTerm: String,
                @Query("ordering") order: String = "highest-rated",
                @Query("page_size") pageSize: Int = 20,
            ): UdemyApiResponse

            @GET("courses")
            suspend fun getFeaturedCourses(
                @Query("ordering") order: String = "relevance",
                @Query("ratings") rating: Double = 4.5
            ): UdemyApiResponse

            @GET("courses")
            suspend fun getTopCourses(
                @Query("page_size") pageSize: Int = 20,
                @Query("price") pricePaid: String = "price-paid",
                @Query("instructional_level") level: String = "intermediate",
                @Query("ordering") order: String = "highest-rated",
                @Query("ratings") rating: Double = 4.5
            ): UdemyApiResponse

            @GET("courses")
            suspend fun getNewCourses(
                @Query("page_size") pageSize: Int = 20,
                @Query("price") pricePaid: String = "price-paid",
                @Query("instructional_level") level: String = "all",
                @Query("ordering") order: String = "newest"
            ): UdemyApiResponse

            @GET("courses")
            suspend fun getStarterCoursesCategory(
                @Query("page_size") pageSize: Int = 20,
                @Query("category") category: String,
                @Query("instructional_level") level: String = "beginner",
                @Query("ordering") order: String = "newest"
            ): UdemyApiResponse

            @GET("courses")
            suspend fun getFeaturedCoursesCategory(
                @Query("page_size") pageSize: Int = 20,
                @Query("category") category: String,
                @Query("ordering") order: String = "highest-rated"
            ): UdemyApiResponse

            @GET("courses")
            suspend fun getPopularCoursesCategory(
                @Query("page_size") pageSize: Int = 20,
                @Query("category") category: String,
                @Query("ordering") order: String = "most-reviewed"
            ): UdemyApiResponse
        }

        object UdemyApi {
            //    Each time app calls MarsApi.retrofitService, the caller will access the same singleton Retrofit object that
//    implements MarsApiService which is created on the first access
            val retrofitService: UdemyApiService by lazy {
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
/*
* private const val BASE_URL = "https://www.udemy.com/api-2.0/"





    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)

        .build()



    object UdemyApi {
        val retrofitService : UdemyApiService by lazy {
            retrofit.create(UdemyApiService::class.java)
        }
    }
*/