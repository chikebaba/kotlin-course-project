package com.example.kotlin_course_project.datasource.remotedatasource.dataclassJsonReceiver

data class Info(
    val count: Int,
    val next: String?,
    val pages: Int,
    val prev: String?
)