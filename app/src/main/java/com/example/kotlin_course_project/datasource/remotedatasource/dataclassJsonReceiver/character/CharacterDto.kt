package com.example.kotlin_course_project.datasource.remotedatasource.dataclassJsonReceiver.character

import com.example.kotlin_course_project.viewmodel.domain.CharacterDomain

data class CharacterDto(
    val result: CharacterData
)


fun CharacterDto.toCharacter(): CharacterDomain {
    return CharacterDomain(
        result = result
    )
}