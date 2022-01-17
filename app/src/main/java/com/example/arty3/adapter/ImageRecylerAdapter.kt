package com.example.arty3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.arty3.databinding.ImageItemBinding

import javax.inject.Inject

class ImageRecylerAdapter @Inject constructor(
    val glide: RequestManager,
) : RecyclerView.Adapter<ImageRecylerAdapter.ImageRecyclerViewHolder>() {

    class ImageRecyclerViewHolder(val binding: ImageItemBinding) :
        RecyclerView.ViewHolder(binding.root)


    private var onItemClickListener: ((String) -> Unit)? = null


    private val diffUtil = object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }

    private val recylerListDiffer = AsyncListDiffer(this, diffUtil)

    var images: List<String>
        get() = recylerListDiffer.currentList
        set(value) = recylerListDiffer.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageRecyclerViewHolder {
        val binding = ImageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageRecyclerViewHolder(binding)
    }

    fun setOnItemClickListener(listener: (String)->Unit){
        onItemClickListener = listener
    }

    override fun onBindViewHolder(holder: ImageRecyclerViewHolder, position: Int) {

        holder.itemView.apply {
            glide.load(images[position]).into(holder.binding.singleImageView)
            setOnItemClickListener {
                onItemClickListener?.let {
                    it(images[position])
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return images.size
    }

}