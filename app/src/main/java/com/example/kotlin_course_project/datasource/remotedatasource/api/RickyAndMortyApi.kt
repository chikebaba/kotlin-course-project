package com.example.kotlin_course_project.datasource.remotedatasource.api

import com.example.kotlin_course_project.datasource.localsource.entities.CharactersList
import com.example.kotlin_course_project.datasource.remotedatasource.dataclassJsonReceiver.character.CharacterData
import com.example.kotlin_course_project.datasource.remotedatasource.dataclassJsonReceiver.episode.EpisodeDto
import com.example.kotlin_course_project.datasource.remotedatasource.dataclassJsonReceiver.episode.EpisodeResult
import com.example.kotlin_course_project.datasource.remotedatasource.dataclassJsonReceiver.location.LocationDto
import com.example.kotlin_course_project.datasource.remotedatasource.dataclassJsonReceiver.location.LocationResults
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickyAndMortyApi {

    @GET("character")
    suspend fun getAllCharacters(
        @Query("status") status: String="",
        @Query("gender") gender: String="",
        @Query("name") name: String="",
        @Query("page") page: Int? = null
    ): CharactersList


    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): CharacterData

    @GET("location")
    suspend fun getAllLocation(@Query("page") page: Int? = null): LocationDto

    @GET("location/{id}")
    suspend fun getLocation(@Path("id") locationId: Int): LocationResults

    @GET("episode")
    suspend fun getAllEpisode(@Query("page") page: Int? = null): EpisodeDto

    @GET("episode/{id}")
    suspend fun getEpisodeById(@Path("id") episodeId: Int): EpisodeResult

}