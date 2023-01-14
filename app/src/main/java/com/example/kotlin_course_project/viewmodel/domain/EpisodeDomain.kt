package com.example.kotlin_course_project.viewmodel.domain

data class EpisodeDomain(
    val id: Int,
    val name: String,
    val air_date: String,
    val episode: String,
    val characters: List<String>
)