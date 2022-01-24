package com.example.eduk8t.domain

import com.example.eduk8t.util.smartTruncate

/**
 * Videos represent a devbyte that can be played.
 */
data class Course(val title: String,
                        val description: String,
                        val url: String,
                        val updated: String,
                        val thumbnail: String) {

    /**
     * Short description is used for displaying truncated descriptions in the UI
     */
    val shortDescription: String
        get() = description.smartTruncate(200)
}