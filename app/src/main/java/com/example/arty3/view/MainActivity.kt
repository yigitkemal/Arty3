package com.example.arty3.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.arty3.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var fragmentFactory: ArtFragmentFactory

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        supportFragmentManager.fragmentFactory = fragmentFactory
        setContentView(view)
    }
}