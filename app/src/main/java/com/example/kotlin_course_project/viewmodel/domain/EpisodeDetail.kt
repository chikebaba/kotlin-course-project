package com.example.kotlin_course_project.viewmodel.domain

data class EpisodeDetail(
    val id: Int,
    val name: String,
    val air_date: String,
    val characters: List<String>,
    val episode: String,
)