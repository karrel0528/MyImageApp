package me.rell.myimageapp.imageList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import me.rell.myimageapp.databinding.FragmentItemBinding

class MyImageListRecyclerViewAdapter :
    PagingDataAdapter<ImageListItem, ImageListViewHolder>(COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageListViewHolder {
        return ImageListViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ImageListViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<ImageListItem>() {
            override fun areItemsTheSame(oldItem: ImageListItem, newItem: ImageListItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: ImageListItem, newItem: ImageListItem): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }
        }
    }
}