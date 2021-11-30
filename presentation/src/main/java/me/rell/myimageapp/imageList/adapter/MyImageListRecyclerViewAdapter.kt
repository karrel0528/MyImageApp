package me.rell.myimageapp.imageList.adapter

import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import me.rell.domain.ImageDomainItem

class MyImageListRecyclerViewAdapter(
    private val itemOnClick: (View, ImageDomainItem) -> Unit
) :
    PagingDataAdapter<ImageDomainItem, ImageListViewHolder>(COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageListViewHolder {
        return ImageListViewHolder.create(parent, itemOnClick)
    }

    override fun onBindViewHolder(holder: ImageListViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<ImageDomainItem>() {
            override fun areItemsTheSame(oldItem: ImageDomainItem, newItem: ImageDomainItem): Boolean {
                return oldItem.url == newItem.url
            }

            override fun areContentsTheSame(oldItem: ImageDomainItem, newItem: ImageDomainItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}