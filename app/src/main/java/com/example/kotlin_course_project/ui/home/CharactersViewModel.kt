package com.example.kotlin_course_project.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CharactersViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is future Characters Fragment"
    }
    val text: LiveData<String> = _text
}