package com.example.kotlin_course_project.viewmodel.state

import com.example.kotlin_course_project.datasource.remotedatasource.dataclassJsonReceiver.character.CharacterData
import com.example.kotlin_course_project.viewmodel.domain.EpisodeDomain

data class CharacterDetailState(
    val character: CharacterData? = null,
    val characterIdFromCharacterListFragment: Int = 1,
    val navigateArgLocationId: Int? = null,
    val episodeList: List<EpisodeDomain>? = null,
    val isLoadingEpisodeInfo: Boolean = false
)