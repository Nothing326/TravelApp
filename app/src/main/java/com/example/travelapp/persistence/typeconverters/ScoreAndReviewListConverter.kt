package com.example.travelapp.persistence.typeconverters

import androidx.room.TypeConverter
import com.example.travelapp.data.vos.ScoreAndReviewVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ScoreAndReviewListConverter {
    @TypeConverter
    fun toString(scoreAndReviewList : ArrayList<ScoreAndReviewVO>) : String{
        return Gson().toJson(scoreAndReviewList)
    }

    @TypeConverter
    fun toScoreAndReviewList(scoreAndReviewJsonString : String): ArrayList<ScoreAndReviewVO>{
        val scoreAndReviewListType = object : TypeToken<ArrayList<ScoreAndReviewVO>>(){}.type
        return Gson().fromJson(scoreAndReviewJsonString,scoreAndReviewListType)
}
}