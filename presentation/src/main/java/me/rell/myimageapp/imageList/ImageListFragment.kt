package me.rell.myimageapp.imageList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import me.rell.myimageapp.databinding.FragmentItemListBinding
import me.rell.myimageapp.imageList.adapter.MyImageListRecyclerViewAdapter
import me.rell.myimageapp.utils.rx.onStop
import me.rell.myimageapp.utils.rx.toAndroidAsync
import timber.log.Timber

@AndroidEntryPoint
class ImageListFragment : Fragment() {

    private lateinit var binding: FragmentItemListBinding

    private val imageListViewModel: ImageListViewModel by viewModels()
    private val imageListAdapter: MyImageListRecyclerViewAdapter by lazy {
        MyImageListRecyclerViewAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentItemListBinding.inflate(inflater, container, false)
        setupRecyclerView()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initImageListViewModel()
    }

    private fun initImageListViewModel() {
        imageListViewModel
            .observePagingImages()
            .toAndroidAsync()
            .onStop(this)
            .subscribe { item ->
                imageListAdapter.submitData(lifecycle, item)
            }
    }

    private fun setupRecyclerView() {
        binding.list.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = imageListAdapter
        }
    }
}