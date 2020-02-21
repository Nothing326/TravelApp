package com.example.travelapp.network.response

import com.example.travelapp.data.vos.CountryVO
import com.example.travelapp.util.CODE_RESPONSE
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GetAllTourResponse(

    @SerializedName("code")
    val code : Int = 0,

    @SerializedName("message")
    val message : String = "",

    @SerializedName("data")
    val data : ArrayList<CountryVO> = arrayListOf()
){
//    fun isResponseOk() : Boolean = (data != null) && (code == CODE_RESPONSE)

}