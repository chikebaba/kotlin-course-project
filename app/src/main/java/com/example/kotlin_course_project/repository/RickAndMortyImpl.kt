package com.example.kotlin_course_project.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.kotlin_course_project.domain.CharacterData
import com.example.kotlin_course_project.domain.CharactersDomain
import com.example.kotlin_course_project.domain.EpisodeDomain
import com.example.kotlin_course_project.domain.LocationDomain


import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RickAndMortyImpl @Inject constructor(
    val api: RickyAndMortyApi,
    private val dao: RickAndMortyDao
) : RickAndMortyRepository {

    override suspend fun getAllCharacters(
        status: StatusState,
        gender: GenderState,
        name: String
    ): Flow<PagingData<CharacterData>> {
        return Pager(
            config = PagingConfig(pageSize = 25),
            pagingSourceFactory = {
                CharactersPagingDataSource(
                    api,
                    statusState = status,
                    genderState = gender,
                    nameQuery = name
                )
            }
        ).flow
    }

    override suspend fun getCharacterDetailById(characterId: Int): CharacterData {

        return api.getCharacter(characterId)
    }

    override suspend fun getAllLocation(): Flow<PagingData<LocationDomain>> {
        return Pager(
            config = PagingConfig(
                pageSize = 25
            ),
            pagingSourceFactory = {
                LocationPagingDataSource(api)
            }
        ).flow
    }

    override suspend fun getLocationDetailById(locationId: Int): LocationResults {
        return api.getLocation(locationId)
    }

    override suspend fun getAllEpisode(): Flow<PagingData<EpisodeDomain>> {
        return Pager(
            config = PagingConfig(pageSize = 25),
            pagingSourceFactory = {
                EpisodePagingDataSource(api)
            }
        ).flow
    }

    override suspend fun getEpisodeById(episodeId: Int): EpisodeResult {
        return api.getEpisodeById(episodeId)
    }

    override suspend fun getAllFavoriteCharacters(): Flow<List<CharactersDomain>> {
        return dao.getAllFavoriteCharacters()
    }

    override suspend fun insertMyFavoriteList(character: CharactersDomain) {
        dao.insertFavoriteCharacter(character = character)
    }

    override suspend fun deleteCharacterFromMyFavoriteList(character: CharactersDomain) {
        dao.deleteFavoriteCharacter(character)
    }

}