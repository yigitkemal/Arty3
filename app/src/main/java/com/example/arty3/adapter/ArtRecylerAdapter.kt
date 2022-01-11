package com.example.arty3.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import javax.inject.Inject

class ArtRecylerAdapter @Inject constructor(
    val glide: RequestManager
): RecyclerView.Adapter<ArtRecylerAdapter.ArtViewHolder>() {
    class ArtViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ArtViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}