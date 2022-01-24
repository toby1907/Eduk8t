package com.example.eduk8t.network

import com.example.eduk8t.database.DatabaseCourse
import com.squareup.moshi.Json
import java.io.Serializable


data class NetworkCourseContainer(val courses: List<NetworkCourse>)

data class NetworkCourse (
    @Json(name = "id")
    val courseId: Int,

    @Json(name = "title")
    val courseTitle: String,

    @Json(name = "headline")
    val courseDescription: String,

    @Json(name = "price")
    val coursePrice: String,

    @Json(name = "url")
    val courseUrl: String,

    @Json(name = "image_125_H")
    val courseImageSmall: String,

    @Json(name = "image_240x135")
    val courseImageMid: String,

    @Json(name = "image_480x270")
    val courseImageLarge: String,

    @Json(name ="is_paid")
    val isPaid: Boolean,

    val price_detail: PriceDetail? = null,

    val visible_instructors: List<VisibleInstructor>
        ): Serializable

data class Option(
    val count: Int,
    val key: String,
    val title: String,
    val value: String
)

data class PriceDetail(
    val amount: Double,
    val currency: String,
    val currency_symbol: String,
    val price_string: String
)

data class VisibleInstructor(
    val _class: String,
    val display_name: String,
    val image_100x100: String,
    val image_50x50: String,
    val initials: String,
    val job_title: String,
    val name: String,
    val title: String,
    val url: String
)
fun NetworkCourseContainer.asDatabaseModel(): List <DatabaseCourse>{
    return courses.map {
        DatabaseCourse(
            id = it.courseId,
            title = it.courseTitle,
            description = it.courseDescription,
            price = it.coursePrice,
            image = it.courseImageLarge,
            url = it.courseUrl,
            instructor = it.visible_instructors[0].display_name,
            instructorTitle = it.visible_instructors[0].job_title,
            instructorImage = it.visible_instructors[0].image_100x100
        )
    }
}


/*
* data class NetworkCourse(
    @Json(name = "id")
    val courseId: Int,

    @Json(name = "title")
    val courseTitle: String,

    @Json(name = "headline")
    val courseDescription: String,

    @Json(name = "price")
    val coursePrice: String,

    @Json(name = "url")
    val courseUrl: String,

    @Json(name = "image_125_H")
    val courseImageSmall: String,

    @Json(name = "image_240x135")
    val courseImageMid: String,

    @Json(name = "image_480x270")
    val courseImageLarge: String,

    @Json(name ="is_paid")
    val isPaid: Boolean,

    val price_detail: PriceDetail? = null,

    val visible_instructors: List<VisibleInstructor>
) : Serializable


data class Option(
    val count: Int,
    val key: String,
    val title: String,
    val value: String
)

data class PriceDetail(
    val amount: Double,
    val currency: String,
    val currency_symbol: String,
    val price_string: String
)

data class VisibleInstructor(
    val _class: String,
    val display_name: String,
    val image_100x100: String,
    val image_50x50: String,
    val initials: String,
    val job_title: String,
    val name: String,
    val title: String,
    val url: String
)
 */