package com.jpmc.a20230130drishtykapoornycschools.view

import com.jpmc.a20230130drishtykapoornycschools.repository.School

interface SchoolDetailViewInterface {
    fun setData(list: List<School>)
}
