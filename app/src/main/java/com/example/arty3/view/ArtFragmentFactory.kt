package com.example.arty3.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.RequestManager
import com.example.arty3.fragment.FragmentDetails
import javax.inject.Inject

class ArtFragmentFactory @Inject constructor(
    private val glide: RequestManager
): FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className){
         FragmentDetails::class.java.name -> FragmentDetails(glide)
         else -> super.instantiate(classLoader, className)
        }

    }
}