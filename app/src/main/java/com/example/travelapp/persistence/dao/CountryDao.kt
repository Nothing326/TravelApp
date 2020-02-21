package com.example.travelapp.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.travelapp.data.vos.CountryVO

@Dao
interface CountryDao {

    @Query("SELECT * FROM country")
    fun getAllCountries():LiveData<List<CountryVO>>

    @Query("SELECT * FROM country WHERE name = :name")
    fun getCountryByName(name : String):LiveData<CountryVO>

    @Insert
    fun insertAllCountries(news : List<CountryVO>)
}