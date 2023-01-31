package com.jpmc.a20230130drishtykapoornycschools.presenter

import android.util.Log
import com.jpmc.a20230130drishtykapoornycschools.adapter.SchoolListAdapter
import com.jpmc.a20230130drishtykapoornycschools.repository.NycSchoolApi
import com.jpmc.a20230130drishtykapoornycschools.repository.School
import com.jpmc.a20230130drishtykapoornycschools.view.HomeFragmentViewInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class HomePresenterImpl @Inject constructor(
    private val nycSchoolApi: NycSchoolApi,
    private val schoolListAdapter: SchoolListAdapter
) :
    HomePresenter {
    override fun getData(callback: HomeFragmentViewInterface) {
        nycSchoolApi.getData().enqueue(object : Callback<List<School>> {
            override fun onResponse(
                call: Call<List<School>?>,
                response: Response<List<School>?>
            ) {
                val responseBody = response.body()!!
                schoolListAdapter.setData(responseBody)

            }

            override fun onFailure(call: Call<List<School>>, t: Throwable) {
                TODO("Not yet implemented")
                Log.d("app", "Failure to fetch data")
            }
        })
    }


    override fun sortData(sortOrder: SortOrder) {
        schoolListAdapter.sort(sortOrder)
    }

    override fun getSchoolListAdapter(): SchoolListAdapter {
        return schoolListAdapter
    }
}