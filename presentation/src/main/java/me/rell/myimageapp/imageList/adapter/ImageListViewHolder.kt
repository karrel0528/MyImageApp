package me.rell.myimageapp.imageList.adapter

import androidx.recyclerview.widget.RecyclerView
import me.rell.domain.ImageDomainItem
import me.rell.myimageapp.databinding.FragmentItemBinding

class ImageListViewHolder(private val binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ImageDomainItem) {
        binding.imageItem = item
    }
}