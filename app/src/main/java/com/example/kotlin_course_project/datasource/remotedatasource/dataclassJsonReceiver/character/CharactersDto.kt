package com.example.kotlin_course_project.datasource.remotedatasource.dataclassJsonReceiver.character

import com.example.kotlin_course_project.datasource.remotedatasource.dataclassJsonReceiver.Info

data class CharactersDto(
    val info: Info,
    val results: List<CharacterData>
)

