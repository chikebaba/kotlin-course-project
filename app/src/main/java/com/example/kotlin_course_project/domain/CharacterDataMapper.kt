package com.example.kotlin_course_project.domain

import androidx.paging.PagingData
import androidx.paging.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CharacterDataMapper {
    fun Flow<PagingData<CharacterData>>.toCharactersDomain(list: List<CharactersDomain>): Flow<Unit> {
        return map { pagingData ->
            pagingData.map { characterData ->
                CharactersDomain(
                    id = characterData.id,
                    name = characterData.name,
                    status = characterData.status,
                    gender = characterData.gender,
                    image = characterData.image,
                    species = characterData.species,
                    isFavorite = list.contains(characterData.toCharactersDomain())
                )
            }
        }
    }

    fun CharacterData.toCharactersDomain(): CharactersDomain {
        return CharactersDomain(
            id = id,
            name = name,
            status = status,
            gender = gender,
            image = image,
            species = species
        )
    }
    }
