package com.example.kotlin_course_project.datasource.localsource.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kotlin_course_project.viewmodel.domain.CharactersDomain

@Database(entities = [CharactersDomain::class], version = 1)
abstract class RickAndMortyDatabase : RoomDatabase() {

    abstract val rickMortyDao: RickAndMortyDao
}