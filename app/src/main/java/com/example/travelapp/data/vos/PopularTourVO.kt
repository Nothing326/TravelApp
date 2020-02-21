package com.example.travelapp.data.vos

import com.google.gson.annotations.SerializedName

data class PopularTourVO(

    @SerializedName("name")
    val name : String = "",

    @SerializedName("description")
    val description : String = "",

    @SerializedName("location")
    val location : String = "",

    @SerializedName("average_rating")
    val averageRating : Double = 0.0,

    @SerializedName("scores_and_reviews")
    val scroesAndReviews : ArrayList<ScoreAndReviewVO> = arrayListOf(),

    @SerializedName("photos")
    val photos: ArrayList<String> = arrayListOf()
)