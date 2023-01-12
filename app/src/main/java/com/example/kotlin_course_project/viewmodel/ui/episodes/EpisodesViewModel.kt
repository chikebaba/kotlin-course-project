package com.example.kotlin_course_project.viewmodel.ui.episodes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EpisodesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Future episodes Fragment"
    }
    val text: LiveData<String> = _text
}