package com.example.travelapp.data.vos

import com.google.gson.annotations.SerializedName

data class MainVO (
    @SerializedName("country")
    val country : ArrayList<CountryVO> = arrayListOf(),

    @SerializedName("popular_tours")
    val popularTour : ArrayList<CountryVO> = arrayListOf()
)