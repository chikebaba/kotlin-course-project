package com.example.kotlin_course_project.domain

import androidx.paging.PagingData
import androidx.paging.map
import com.example.kotlin_course_project.dataclass.Origin
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

data class CharacterData(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origin,
    val location: Location,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)
