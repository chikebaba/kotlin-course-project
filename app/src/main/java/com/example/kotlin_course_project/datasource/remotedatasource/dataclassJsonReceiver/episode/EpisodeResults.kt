package com.example.kotlin_course_project.datasource.remotedatasource.dataclassJsonReceiver.episode

import com.example.kotlin_course_project.viewmodel.domain.EpisodeDetail
import com.example.kotlin_course_project.viewmodel.domain.EpisodeDomain

data class EpisodeResult(
    val id: Int,
    val name: String,
    val air_date: String,
    val characters: List<String>,
    val url: String,
    val episode: String,
    val created: String
)

fun EpisodeResult.toEpisodeByIdDetail(): EpisodeDetail {

    return EpisodeDetail(
        id = id,
        name = name,
        air_date = air_date,
        episode =episode,
        characters = characters
    )

}

fun EpisodeResult.toEpisodeDomain(): EpisodeDomain {

    return EpisodeDomain(
        id = id,
        name = name,
        air_date = air_date,
        episode = episode,
        characters = characters
    )

}
