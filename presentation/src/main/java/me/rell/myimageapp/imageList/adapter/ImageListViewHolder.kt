package me.rell.myimageapp.imageList.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.rell.domain.ImageDomainItem
import me.rell.myimageapp.databinding.FragmentItemBinding

class ImageListViewHolder(
    private val binding: FragmentItemBinding,
    private val itemOnClick: (View, ImageDomainItem) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ImageDomainItem) {
        binding.imageItem = item

        binding.listImage.setOnClickListener { view ->
            itemOnClick(view, item)
        }
    }

    companion object {
        fun create(parent: ViewGroup, itemOnClick: (View, ImageDomainItem) -> Unit): ImageListViewHolder {

            val viewBinding = FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

            return ImageListViewHolder(
                viewBinding,
                itemOnClick
            )
        }
    }
}