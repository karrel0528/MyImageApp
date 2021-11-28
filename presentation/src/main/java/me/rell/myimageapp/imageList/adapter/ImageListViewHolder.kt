package me.rell.myimageapp.imageList.adapter

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import me.rell.myimageapp.databinding.FragmentItemBinding

class ImageListViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
    private val imageView: ImageView = binding.listImage

    fun bind(item: ImageListItem) {
        setImage(item.imageUrl)
    }

    private fun setImage(url: String) {
        Glide.with(imageView)
            .load(url)
            .centerCrop()
            .into(imageView)
    }
}