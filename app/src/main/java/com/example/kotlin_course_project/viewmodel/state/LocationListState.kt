package com.example.kotlin_course_project.viewmodel.state

import androidx.paging.PagingData
import com.example.kotlin_course_project.viewmodel.domain.LocationDomain

data class LocationListState(
    val locationData: PagingData<LocationDomain>? = PagingData.empty()
)