package com.jpmc.a20230130drishtykapoornycschools.di

import com.jpmc.a20230130drishtykapoornycschools.repository.NycSchoolApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
object ApiModule {

    @Provides
    fun provideSchoolInfoApi(retrofit: Retrofit): NycSchoolApi {
        return retrofit.create(NycSchoolApi::class.java)
    }

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://data.cityofnewyork.us/")
            .build()
    }
}