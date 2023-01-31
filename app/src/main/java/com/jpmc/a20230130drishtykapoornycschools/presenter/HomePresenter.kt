package com.jpmc.a20230130drishtykapoornycschools.presenter

import com.jpmc.a20230130drishtykapoornycschools.adapter.SchoolListAdapter
import com.jpmc.a20230130drishtykapoornycschools.view.HomeFragmentViewInterface

interface HomePresenter {
    fun getData(callback: HomeFragmentViewInterface)
    fun sortData(sortOrder: SortOrder)
    fun getSchoolListAdapter(): SchoolListAdapter
}
