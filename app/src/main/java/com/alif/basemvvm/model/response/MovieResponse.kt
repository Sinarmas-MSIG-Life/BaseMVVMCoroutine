package com.alif.basemvvm.model.response

import com.alif.basemvvm.model.data.Movie
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results")
    val results: List<Movie>
)