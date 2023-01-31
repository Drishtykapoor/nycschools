package com.jpmc.a20230130drishtykapoornycschools.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.jpmc.a20230130drishtykapoornycschools.databinding.SchoolDetailFragmentBinding
import com.squareup.picasso.Picasso
import dagger.android.support.DaggerFragment


class SchoolDetailFragment : DaggerFragment() {

    private lateinit var binding: SchoolDetailFragmentBinding

    private val args: SchoolDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SchoolDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onResume() {
        super.onResume()
        binding.title.text = args.schoolData.school_name
        binding.zipcode.text = args.schoolData.zip
        binding.total.text = args.schoolData.total_students
        Picasso.with(context).isLoggingEnabled = true
        Picasso.with(context).load(listOfRandomSchoolImages[0]).into(binding.imageView)

    }

    private val listOfRandomSchoolImages =
        listOf("https://thumbs.dreamstime.com/b/bronx-ny-usa-new-york-city-public-school-building-beneath-cloud-filled-sky-171346134.jpg")
}