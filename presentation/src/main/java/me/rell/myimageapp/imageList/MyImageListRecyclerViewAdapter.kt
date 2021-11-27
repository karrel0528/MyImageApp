package me.rell.myimageapp.imageList

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import me.rell.myimageapp.databinding.FragmentItemBinding

class MyImageListRecyclerViewAdapter(
    private val values: List<ImageListItem>
) : RecyclerView.Adapter<MyImageListRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        // todo item.setImage
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val imageView: ImageView = binding.listImage

        fun setImage(url: String) {
            // todo load image
        }
    }
}