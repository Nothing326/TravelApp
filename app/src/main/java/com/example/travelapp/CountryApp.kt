package com.example.travelapp

import android.app.Application
import com.example.travelapp.data.models.CountryModelImpl


class CountryApp : Application() {
    override fun onCreate() {
        super.onCreate()
        CountryModelImpl.initDatabase(applicationContext)
    }
}