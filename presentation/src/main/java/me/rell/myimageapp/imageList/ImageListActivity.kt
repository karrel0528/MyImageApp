package me.rell.myimageapp.imageList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import me.rell.myimageapp.databinding.ActivityImageBinding

@AndroidEntryPoint
class ImageListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageBinding.inflate(LayoutInflater.from(this))

        setContentView(binding.root)
    }
}