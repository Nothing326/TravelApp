package com.example.travelapp.data.models

import androidx.lifecycle.LiveData
import com.example.travelapp.data.vos.CountryVO
import com.example.travelapp.data.vos.MainVO
import io.reactivex.Observable

interface CountryModel {

    fun getAllPopularTourAndCountry() : Observable<MainVO>

    fun getDataByName(name: String) : LiveData<CountryVO>


}