package com.alif.basemvvm.di.module

import com.alif.basemvvm.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector
    abstract fun contributesMainActivity(): MainActivity
}