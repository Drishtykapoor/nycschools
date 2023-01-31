package com.jpmc.a20230130drishtykapoornycschools.repository

import retrofit2.Call
import retrofit2.http.GET

interface NycSchoolApi {
    @GET("resource/s3k6-pzi2.json")
    fun getData(): Call<List<School>>
}