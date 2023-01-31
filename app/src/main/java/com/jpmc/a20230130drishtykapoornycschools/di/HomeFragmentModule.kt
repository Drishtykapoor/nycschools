package com.jpmc.a20230130drishtykapoornycschools.di

import com.jpmc.a20230130drishtykapoornycschools.view.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [HomeFragmentDependenciesModule::class])
abstract class HomeFragmentModule {

    @ContributesAndroidInjector
    abstract fun provideHomeFragment(): HomeFragment
}