package com.alif.basemvvm.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.alif.basemvvm.R
import com.alif.basemvvm.base.BaseViewModel
import com.alif.basemvvm.common.ResultState
import com.alif.basemvvm.model.data.Movie
import com.alif.basemvvm.repository.MoviesRepository
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.IOException
import java.util.concurrent.TimeoutException
import javax.inject.Inject

class MoviesViewModel @Inject constructor(private val repository: MoviesRepository) : BaseViewModel() {
    private val _movie = MutableLiveData<ResultState<List<Movie>>>()
    val movie: LiveData<ResultState<List<Movie>>> get() = _movie

    init {
        getNowPlaying()
    }

    private fun getNowPlaying() {
        setResultNowPlaying(ResultState.Loading())
        viewModelScope.launch {
            val response = repository.getNowPlaying()
            val result = response.results
            try {
                if (result.isEmpty()) {
                    setResultNowPlaying(ResultState.NoData())
                    return@launch
                }
                setResultNowPlaying(ResultState.HasData(result))
            } catch (e: Throwable) {
                when (e) {
                    is IOException -> setResultNowPlaying(ResultState.NoInternetConnection())
                    is TimeoutException ->  setResultNowPlaying(ResultState.Error(R.string.timeout))
                    else -> setResultNowPlaying(ResultState.Error(R.string.unknown_error))
                }
            }
        }
    }

    private fun setResultNowPlaying(result: ResultState<List<Movie>>) {
        _movie.postValue(result)
    }
}
