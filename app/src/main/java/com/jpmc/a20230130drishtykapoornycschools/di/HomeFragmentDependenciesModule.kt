package com.jpmc.a20230130drishtykapoornycschools.di

import com.jpmc.a20230130drishtykapoornycschools.presenter.HomePresenter
import com.jpmc.a20230130drishtykapoornycschools.presenter.HomePresenterImpl
import dagger.Binds
import dagger.Module

@Module
interface HomeFragmentDependenciesModule {

    @Binds
    fun provideHomePresenter(homePresenterImpl: HomePresenterImpl): HomePresenter
}
