package edu.bo.framework.apidata.server

import com.google.gson.annotations.SerializedName

data class Movie(
    val title: String,
    @SerializedName("poster_path") val posterPath: String)