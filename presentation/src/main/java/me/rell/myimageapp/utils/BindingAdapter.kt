package me.rell.myimageapp.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("thumbnail")
fun ImageView.loadImageUrl(url: String) {
    Glide.with(this.context)
        .load(url)
        .centerCrop()
        .into(this)
}