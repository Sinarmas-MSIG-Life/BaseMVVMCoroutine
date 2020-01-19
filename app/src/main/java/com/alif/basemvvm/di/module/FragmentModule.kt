package com.alif.basemvvm.di.module

import com.alif.basemvvm.ui.movies.MoviesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun contributesMoviesFragment(): MoviesFragment
}