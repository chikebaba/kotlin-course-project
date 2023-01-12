package com.example.kotlin_course_project.viewmodel.domain

data class LocationByIdDomain(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>,
)
