package com.example.travelapp.persistence.typeconverters

import androidx.room.TypeConverter
import com.example.travelapp.data.vos.ScoreAndReviewVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PhotoListConverter {
    @TypeConverter
    fun toString(photoList : ArrayList<String>) : String{
        return Gson().toJson(photoList)
    }

    @TypeConverter
    fun toPhotoList(photoJsonString : String): ArrayList<String>{
        val photoListType = object : TypeToken<ArrayList<String>>(){}.type
        return Gson().fromJson(photoJsonString,photoListType)
    }
}