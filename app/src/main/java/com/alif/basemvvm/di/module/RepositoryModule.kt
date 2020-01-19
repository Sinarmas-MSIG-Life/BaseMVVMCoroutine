package com.alif.basemvvm.di.module

import com.alif.basemvvm.api.ApiService
import com.alif.basemvvm.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideMoviesRepository(apiService: ApiService) = MoviesRepository(apiService)
}