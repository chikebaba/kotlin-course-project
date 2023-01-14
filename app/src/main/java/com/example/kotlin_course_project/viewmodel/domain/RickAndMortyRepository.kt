package com.example.kotlin_course_project.viewmodel.domain

import androidx.paging.PagingData
import com.example.kotlin_course_project.datasource.remotedatasource.dataclassJsonReceiver.character.CharacterData
import com.example.kotlin_course_project.datasource.remotedatasource.dataclassJsonReceiver.episode.EpisodeResult
import com.example.kotlin_course_project.datasource.remotedatasource.dataclassJsonReceiver.location.LocationResults
import com.example.kotlin_course_project.misc.enums.GenderState
import com.example.kotlin_course_project.misc.enums.StatusState
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

    suspend fun getLocationDetailById(locationId: Int): LocationResults

    suspend fun getAllEpisode(): Flow<PagingData<EpisodeDomain>>

    suspend fun getEpisodeById(@Path("id") episodeId: Int): EpisodeResult

    suspend fun getAllFavoriteCharacters(): Flow<List<CharactersDomain>>

    suspend fun insertMyFavoriteList(character: CharactersDomain)

    suspend fun deleteCharacterFromMyFavoriteList(character: CharactersDomain)
}