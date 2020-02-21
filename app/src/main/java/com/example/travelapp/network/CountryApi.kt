package com.example.travelapp.network

import com.example.travelapp.network.response.GetAllTourResponse
import com.example.travelapp.util.GET_COUNTRIES
import com.example.travelapp.util.GET_TOURS
import io.reactivex.Observable
import retrofit2.http.GET

interface CountryApi {
    @GET(GET_COUNTRIES)
    fun getAllCountries(): Observable<GetAllTourResponse>

    @GET(GET_TOURS)
    fun getAllTours(): Observable<GetAllTourResponse>

}