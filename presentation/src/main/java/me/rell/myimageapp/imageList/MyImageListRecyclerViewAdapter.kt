package me.rell.myimageapp.imageList

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import me.rell.myimageapp.databinding.FragmentItemBinding

class MyImageListRecyclerViewAdapter(
) : RecyclerView.Adapter<MyImageListRecyclerViewAdapter.ViewHolder>() {
    var items: List<ImageListItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.setImage(item.imageUrl)
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val imageView: ImageView = binding.listImage

        fun setImage(url: String) {
            Glide.with(imageView)
                .load(url)
                .centerCrop()
                .into(imageView)
        }
    }
}