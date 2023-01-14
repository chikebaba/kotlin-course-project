package com.example.kotlin_course_project.datasource.remotedatasource.dataclassJsonReceiver.episode

import com.example.kotlin_course_project.datasource.remotedatasource.dataclassJsonReceiver.Info
import com.example.kotlin_course_project.viewmodel.domain.EpisodeDomain

data class EpisodeDto(
    val info: Info,
    val results: List<EpisodeResult>
)

fun EpisodeDto.toEpisodeDomain(): List<EpisodeDomain> {

    return results.map {
        EpisodeDomain(
            id = it.id,
            name = it.name,
            air_date = it.air_date,
            episode = it.episode,
            characters = it.characters
        )
    }
}