package com.example.arty3.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.RequestManager
import com.example.arty3.adapter.ArtRecylerAdapter
import com.example.arty3.adapter.ImageRecylerAdapter
import com.example.arty3.fragment.FragmentArts
import com.example.arty3.fragment.FragmentDetails
import com.example.arty3.fragment.FragmentImageApi
import javax.inject.Inject

class ArtFragmentFactory @Inject constructor(
    private val artRecylerAdapter: ArtRecylerAdapter,
    private val glide: RequestManager,
    private val imageRecyclerAdapter: ImageRecylerAdapter
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            FragmentArts::class.java.name -> FragmentArts(artRecylerAdapter)
            FragmentDetails::class.java.name -> FragmentDetails(glide)
            FragmentImageApi::class.java.name -> FragmentImageApi(imageRecyclerAdapter)
            else -> super.instantiate(classLoader, className)
        }

    }
}