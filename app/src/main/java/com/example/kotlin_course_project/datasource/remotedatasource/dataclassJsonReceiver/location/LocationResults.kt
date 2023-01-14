package com.example.kotlin_course_project.datasource.remotedatasource.dataclassJsonReceiver.location

import com.example.kotlin_course_project.viewmodel.domain.LocationByIdDomain

data class LocationResults(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>,
    val url: String,
    val created: String
)

fun LocationResults.toLocationByIdDomain(): LocationByIdDomain {

    return LocationByIdDomain(
        id = id,
        name = name,
        type = type,
        dimension = dimension,
        residents = residents
    )
}