package com.example.travelapp.persistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.travelapp.data.vos.CountryVO
import com.example.travelapp.persistence.dao.CountryDao

@Database(entities = [CountryVO::class],version = 1)
abstract class CountryDB : RoomDatabase() {

    companion object{
        val DB_NAME = "PADC_X_COUNTRIES.DB"
        var dbInstance : CountryDB? = null
        fun getDBInstance(context : Context) : CountryDB{
            when(dbInstance){
                null ->{
                    dbInstance = Room.databaseBuilder(context,CountryDB::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            val i = dbInstance
            return i!!
        }
    }
    abstract  fun CountryDao(): CountryDao

}