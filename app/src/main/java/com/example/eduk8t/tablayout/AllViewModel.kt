package com.example.eduk8t.tablayout

import android.app.Application
import androidx.lifecycle.*
import com.example.eduk8t.database.CourseDao
import com.example.eduk8t.database.CoursesDatabase
import com.example.eduk8t.domain.Course
import com.example.eduk8t.network.asDomainModel
import com.example.eduk8t.repository.CoursesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class AllViewModel(dataSource: CourseDao, application: Application) : ViewModel() {
    // TODO: Implement the ViewModel
    private val databaseCourse = CoursesDatabase.getInstance(application)
   private val coursesRepository = CoursesRepository(databaseCourse)

    private val _topCourses = MutableLiveData<List<Course>>()
    val topCourses : LiveData<List<Course>>
        get() = _topCourses
    init {
        getTopCourses()
    }

    private fun getTopCourses() {
        viewModelScope.launch {
            try {

                val resultList = coursesRepository.getTopCourses().asDomainModel()
                if(resultList.isNotEmpty()) {
                    _topCourses.value = resultList

                }
            } catch (e : Exception) {

            }
        }
    }





}