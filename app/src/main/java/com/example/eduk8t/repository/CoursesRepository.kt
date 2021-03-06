package com.example.eduk8t.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.eduk8t.database.CoursesDatabase
import com.example.eduk8t.database.DatabaseCourse
import com.example.eduk8t.database.asDomainModel
import com.example.eduk8t.domain.Course
import com.example.eduk8t.network.UdemyApi
import com.example.eduk8t.network.UdemyApiService
import com.example.eduk8t.network.asDatabaseModel

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CoursesRepository (private val database: CoursesDatabase){

    val courses : LiveData<List<Course>> = Transformations.map(database.courseDao.getCourses()){
        it.asDomainModel()
    }

    val bookmarkedCourses : LiveData<List<Course>> = Transformations.map(database.courseDao.getBookmarkedCourses()) {
        it.asDomainModel()
    }


    suspend fun refreshCourses() {
        withContext(Dispatchers.IO){
            try {
                val coursesList = UdemyApi.retrofitService.getCourses()
                Log.i("Repo class", coursesList.results.toString())
                database.courseDao.insertAll(*coursesList.asDatabaseModel())
            } catch (e : Exception) {
                Log.i("Failure", e.message.toString())
            }

        }
    }

    suspend fun searchCourse(searchTerm: String)  =
       UdemyApi.retrofitService.searchCourses(searchTerm)

    suspend fun updateCourse(course: DatabaseCourse){
        database.courseDao.updateCourse(course)
    }

    suspend fun insertCourse(course: DatabaseCourse) {
        database.courseDao.insertCourse(course)
    }

    suspend fun deleteCourse(course: DatabaseCourse) = database.courseDao.deleteCourse(course)

    suspend fun getFeaturedCourses() = UdemyApi.retrofitService.getFeaturedCourses()

    suspend fun getTopCourses() = UdemyApi.retrofitService.getTopCourses()

    suspend fun getNewCourses() = UdemyApi.retrofitService.getNewCourses()

    suspend fun getStarterCoursesCategory(category: String) =
       UdemyApi.retrofitService.getStarterCoursesCategory(category = category)

    suspend fun getFeaturedCoursesCategory(category: String) =
        UdemyApi.retrofitService.getFeaturedCoursesCategory(category =  category)


    suspend fun getPopularCoursesCategory(category: String) =
        UdemyApi.retrofitService.getPopularCoursesCategory(category = category)


}