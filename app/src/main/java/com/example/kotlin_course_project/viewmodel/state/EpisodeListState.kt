package com.example.kotlin_course_project.viewmodel.state

import androidx.paging.PagingData
import com.example.kotlin_course_project.viewmodel.domain.EpisodeListItem

data class EpisodeListState(
    val episodeList: PagingData<EpisodeListItem>? = PagingData.empty(),
)