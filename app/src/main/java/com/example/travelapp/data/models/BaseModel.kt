package com.example.travelapp.data.models


import android.content.Context
import com.example.travelapp.network.CountryApi
import com.example.travelapp.persistence.db.CountryDB
import com.example.travelapp.util.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel {
    protected var mCountryApi : CountryApi
    protected  lateinit var mTheDB: CountryDB

    init {
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(mOkHttpClient)
            .build()

        mCountryApi = retrofit.create(CountryApi::class.java)



    }

    fun initDatabase(context: Context){
        mTheDB = CountryDB.getDBInstance(context)
    }
}