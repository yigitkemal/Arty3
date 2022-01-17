package com.example.arty3.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.example.arty3.R
import com.example.arty3.adapter.ImageRecylerAdapter
import com.example.arty3.databinding.FragmentImageApiBinding
import javax.inject.Inject

class FragmentImageApi @Inject constructor(
    private val imageRecylerAdapter: ImageRecylerAdapter
): Fragment() {

    private lateinit var binding: FragmentImageApiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentImageApiBinding.inflate(layoutInflater,container,false)
        val view = binding.root

        return view
    }


}