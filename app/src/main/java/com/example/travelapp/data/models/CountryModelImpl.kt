package com.example.travelapp.data.models

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.LiveData
import com.example.travelapp.data.vos.CountryVO
import com.example.travelapp.data.vos.MainVO
import com.example.travelapp.persistence.db.CountryDB
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers

object CountryModelImpl : CountryModel, BaseModel() {

    @SuppressLint("CheckResult")
    override fun getAllPopularTourAndCountry(): Observable<MainVO> {


        getCountryListObservable()
            .subscribe{
                mTheDB.CountryDao().insertAllCountries(it)
            }
        getTourListObservable()
            .subscribe{
                mTheDB.CountryDao().insertAllCountries(it)
            }


        return Observable.zip(
            getCountryListObservable(),
            getTourListObservable(),
            mergerListForMainVO()
        )
    }


    private fun getCountryListObservable(): Observable<List<CountryVO>> {
        return mCountryApi.getAllCountries()
            .map { it.data.toList() }
            .subscribeOn(Schedulers.io())
    }

    private fun getTourListObservable(): Observable<List<CountryVO>> {
        return mCountryApi.getAllTours()
            .map { it.data.toList() }
            .subscribeOn(Schedulers.io())
    }


    override fun getDataByName(name: String): LiveData<CountryVO> {

        return mTheDB.CountryDao().getCountryByName(name)
    }


    private fun mergerListForMainVO(): BiFunction<List<CountryVO>, List<CountryVO>, MainVO> {

        return BiFunction { t1, t2 ->
            val countryList = ArrayList<CountryVO>()
            val popularTourList = ArrayList<CountryVO>()

            countryList.addAll(t1)
            popularTourList.addAll(t2)


            MainVO(countryList, popularTourList)
        }
    }


}