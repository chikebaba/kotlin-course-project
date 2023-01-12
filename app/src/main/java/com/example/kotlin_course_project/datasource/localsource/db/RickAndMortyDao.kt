package com.example.kotlin_course_project.datasource.localsource.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.kotlin_course_project.viewmodel.domain.CharactersDomain
import kotlinx.coroutines.flow.Flow

@Dao
interface RickAndMortyDao {

    @Insert
    suspend fun insertCharacter(character: CharactersDomain)

    @Delete
    suspend fun deleteCharacter(character: CharactersDomain)

    @Query("SELECT * FROM charactersdomain")
    fun getAllCharacters(): Flow<List<CharactersDomain>>
}