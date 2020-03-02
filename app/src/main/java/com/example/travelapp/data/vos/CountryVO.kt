package com.example.travelapp.data.vos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.travelapp.persistence.typeconverters.PhotoListConverter
import com.example.travelapp.persistence.typeconverters.ScoreAndReviewListConverter
import com.google.gson.annotations.SerializedName

@Entity(tableName = "country")
@TypeConverters(ScoreAndReviewListConverter::class,PhotoListConverter::class)

data class CountryVO(

    @SerializedName("name")
    val name : String = "",

    @SerializedName("description")
    val description : String = "",

    @SerializedName("location")
    val location : String = "",

    @SerializedName("average_rating")
    val averageRating : Double = 0.0,

    @SerializedName("scores_and_reviews")
    val scoresAndReviews : ArrayList<ScoreAndReviewVO> = arrayListOf(),

    @SerializedName("photos")
    val photos: ArrayList<String> = arrayListOf()
){

        @PrimaryKey(autoGenerate = true)
        var id: Int = 0

}