package com.jpmc.a20230130drishtykapoornycschools.di

import com.jpmc.a20230130drishtykapoornycschools.view.SchoolDetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [SchoolDetailFragmentDependenciesModule::class])
abstract class SchoolDetailModule {

    @ContributesAndroidInjector
    abstract fun provideSchoolDetailFragment(): SchoolDetailFragment
}