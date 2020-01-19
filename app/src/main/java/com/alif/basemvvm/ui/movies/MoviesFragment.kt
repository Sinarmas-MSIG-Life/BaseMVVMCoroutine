package com.alif.basemvvm.ui.movies

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.alif.basemvvm.R
import com.alif.basemvvm.base.BaseFragment
import com.alif.basemvvm.common.ResultState
import com.alif.basemvvm.databinding.FragmentMoviesBinding
import com.alif.basemvvm.model.data.Movie

class MoviesFragment : BaseFragment<FragmentMoviesBinding, MoviesViewModel>(), MoviesAdapter.OnMoviesPressedListener {
    private val adapter = MoviesAdapter(this)

    override fun getViewModelClass(): Class<MoviesViewModel> = MoviesViewModel::class.java

    override fun getLayoutResourceId(): Int = R.layout.fragment_movies

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()

        vm.movie.observe(viewLifecycleOwner, Observer {
            it?.let {
                when (it) {
                    is ResultState.Loading -> {
                        hideLeagues()
                        showLoading()
                    }
                    is ResultState.HasData -> {
                        showLeagues()
                        hideLoading()
                        refreshData(it.data)
                    }
                    is ResultState.NoData -> {
                        hideLeagues()
                        hideLoading()
                        snackBar(resources.getString(R.string.empty_data))
                    }
                    is ResultState.Error -> {
                        hideLeagues()
                        hideLoading()
                        snackBar(resources.getString(R.string.unknown_error))
                    }
                    is ResultState.NoInternetConnection -> {
                        hideLeagues()
                        hideLoading()
                        snackBar(resources.getString(R.string.no_connection))
                    }
                }
            }
        })
    }

    override fun onMoviesPressed(movies: Movie, position: Int) {
        snackBar(movies.title)
    }

    private fun initRecyclerView() {
        binding.rvMovies.adapter = adapter
    }

    private fun refreshData(movies : List<Movie>) {
        adapter.submitList(movies)
    }

    private fun showLoading() {
        binding.showLoading = true
    }

    private fun hideLoading() {
        binding.showLoading = false
    }

    private fun showLeagues() {
        binding.showData = true
    }

    private fun hideLeagues() {
        binding.showData = false
    }
}
