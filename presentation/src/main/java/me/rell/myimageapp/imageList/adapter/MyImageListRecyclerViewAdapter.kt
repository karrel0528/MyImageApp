package me.rell.myimageapp.imageList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import me.rell.domain.ImageDomainItem
import me.rell.myimageapp.databinding.FragmentItemBinding

class MyImageListRecyclerViewAdapter :
    PagingDataAdapter<ImageDomainItem, ImageListViewHolder>(COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageListViewHolder {
        return ImageListViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ImageListViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<ImageDomainItem>() {
            override fun areItemsTheSame(oldItem: ImageDomainItem, newItem: ImageDomainItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: ImageDomainItem, newItem: ImageDomainItem): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }
        }
    }
}