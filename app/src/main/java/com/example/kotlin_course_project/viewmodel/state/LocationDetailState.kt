package com.example.kotlin_course_project.viewmodel.state

import com.example.kotlin_course_project.viewmodel.domain.CharactersDomain
import com.example.kotlin_course_project.viewmodel.domain.LocationByIdDomain

data class LocationDetailState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val locationInfo: LocationByIdDomain? = null,
    val locationID: Int = 0,
    val characterList: List<CharactersDomain>? = null
)