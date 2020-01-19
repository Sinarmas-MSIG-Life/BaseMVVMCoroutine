package com.alif.basemvvm.model.data

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("vote_count")
    val vote_count: Int,
    @SerializedName("poster_path")
    val poster_path: String,
    @SerializedName("id")
    val idMovies: Int,
    @SerializedName("backdrop_path")
    val backdrop_path: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("vote_average")
    val vote_average: Double,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("release_date")
    val release_date: String
)