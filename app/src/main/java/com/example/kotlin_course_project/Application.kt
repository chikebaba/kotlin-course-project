package com.example.kotlin_course_project

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kotlin.text.Typography.dagger

@HiltAndroidApp
class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

}