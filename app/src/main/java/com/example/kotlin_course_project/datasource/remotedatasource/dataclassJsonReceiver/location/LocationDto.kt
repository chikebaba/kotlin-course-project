package com.example.kotlin_course_project.datasource.remotedatasource.dataclassJsonReceiver.location

import com.example.kotlin_course_project.datasource.remotedatasource.dataclassJsonReceiver.Info
import com.example.kotlin_course_project.viewmodel.domain.LocationDomain

data class LocationDto(
    val info: Info,
    val results: List<LocationResults>
)


fun LocationDto.toLocationDomain(): List<LocationDomain> {

    return results.map {
        LocationDomain(
            dimension = it.dimension,
            id = it.id,
            name = it.name,
            type = it.type
        )
    }
}