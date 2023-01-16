package com.example.kotlin_course_project.viewmodel.state

import com.example.kotlin_course_project.viewmodel.domain.CharactersDomain
import com.example.kotlin_course_project.viewmodel.domain.EpisodeDetail

data class EpisodeDetailState(
    val isLoading: Boolean = false,
    val characterList: List<CharactersDomain>? = null,
    val episodeId: Int = 0,
    val episodeDetailInfo: EpisodeDetail? = null,
    val error: String = ""
)
