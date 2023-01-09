package com.example.kotlin_course_project.repository

import androidx.paging.PagingData
import com.example.kotlin_course_project.domain.CharacterData
import com.example.kotlin_course_project.domain.CharactersDomain
import com.example.kotlin_course_project.domain.EpisodeDomain
import com.example.kotlin_course_project.domain.LocationDomain

import kotlinx.coroutines.flow.Flow
import retrofit2.http.Path

interface RickAndMortyRepository {

    suspend fun getAllCharacters(
        status: StatusState = StatusState.NONE,
        gender: GenderState = GenderState.NONE,
        name: String = ""
    ): Flow<PagingData<CharacterData>>


    suspend fun getCharacterDetailById(characterId: Int): CharacterData

    suspend fun getAllLocation(): Flow<PagingData<LocationDomain>>

    suspend fun getAllEpisode(): Flow<PagingData<EpisodeDomain>>
}
