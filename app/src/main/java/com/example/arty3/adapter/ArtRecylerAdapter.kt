package com.example.arty3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.arty3.R
import com.example.arty3.databinding.ArtItemBinding
import com.example.arty3.model.Art
import javax.inject.Inject

class ArtRecylerAdapter @Inject constructor(
    val glide: RequestManager
) : RecyclerView.Adapter<ArtRecylerAdapter.ArtViewHolder>() {

    class ArtViewHolder(val binding: ArtItemBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffUtil = object : DiffUtil.ItemCallback<Art>() {
        override fun areItemsTheSame(oldItem: Art, newItem: Art): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Art, newItem: Art): Boolean {
            return oldItem == newItem
        }
    }

    private val recylerListDiffer = AsyncListDiffer(this, diffUtil)

    var artList: List<Art>
        get() = recylerListDiffer.currentList
        set(value) = recylerListDiffer.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtViewHolder {
        val binding = ArtItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ArtViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtViewHolder, position: Int) {
        val art = artList[position]
        holder.itemView.apply {
            holder.binding.artName.setText(art.name)
            holder.binding.artistName.setText(art.artistName)
            holder.binding.artBuildYear.setText(art.year)
            glide.load(art.imageUrl).into(holder.binding.imageView)
            // description will added
        }
    }

    override fun getItemCount(): Int {
        return artList.size
    }
}