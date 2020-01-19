package com.alif.basemvvm.api

import com.alif.basemvvm.model.response.MovieResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("now_playing")
    suspend fun getNowPlaying(@Query("language") language: String) : MovieResponse
}