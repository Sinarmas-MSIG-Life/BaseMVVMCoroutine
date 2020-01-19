package com.alif.basemvvm.repository

import com.alif.basemvvm.api.ApiService
import com.alif.basemvvm.common.LANGUAGE
import com.alif.basemvvm.model.data.Movie
import com.alif.basemvvm.model.response.MovieResponse
import io.reactivex.Observable
import javax.inject.Inject

class MoviesRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getNowPlaying() : MovieResponse {
        return apiService.getNowPlaying(LANGUAGE)
    }
}