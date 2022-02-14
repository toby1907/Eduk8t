package com.example.eduk8t.domain

import com.example.eduk8t.util.smartTruncate

/**
 * Videos represent a devbyte that can be played.
 */
data class Course(val id : Int,
                  val title: String,
                  val description: String,
                  val price: String,
                  val image: String,
                  val url: String,
                  val instructor: String,
                  val instructorTitle: String,
                  val instructorImage: String,
                  var isBookmarked: Boolean = false) {

    /**
     * Short description is used for displaying truncated descriptions in the UI
     */
    val shortDescription: String
        get() = description.smartTruncate(200)
}