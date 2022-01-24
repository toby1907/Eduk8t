package com.example.eduk8t.database


import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CourseDao {
    @Query("select * from DatabaseCourse")
    fun getVideos(): LiveData<List<DatabaseCourse>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll( videos: List<DatabaseCourse>)
}

@Database(entities = [DatabaseCourse::class], version = 1)
abstract class VideosDatabase: RoomDatabase() {
    abstract val courseDao: CourseDao
}
private lateinit var INSTANCE: VideosDatabase

fun getDatabase(context: Context): VideosDatabase {
    synchronized(VideosDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                VideosDatabase::class.java,
                "videos").build()
        }
    }
    return INSTANCE
}