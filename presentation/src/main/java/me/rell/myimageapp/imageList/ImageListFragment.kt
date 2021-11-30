package me.rell.myimageapp.imageList

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import me.rell.myimageapp.databinding.FragmentItemListBinding
import me.rell.myimageapp.imageList.adapter.MyImageListRecyclerViewAdapter
import me.rell.myimageapp.utils.ResponseResult
import me.rell.myimageapp.utils.rx.onStop
import me.rell.myimageapp.utils.rx.toAndroidAsync

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
        imageListViewModel.pagingImageDomainData
            .observe(viewLifecycleOwner) { result ->
                when (result) {
                    is ResponseResult.Success -> {
                        imageListAdapter.submitData(lifecycle, result.data)
                        hideLoadFailMessage()
                    }
                    is ResponseResult.Fail    -> {
                        showLoadFailMessage()
                    }
                }
            }
    }

    private fun showLoadFailMessage() {
        binding.loadFailMessage.isVisible = true
    }

    private fun hideLoadFailMessage() {
        binding.loadFailMessage.isVisible = false
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = imageListAdapter
        }

        imageListAdapter.addLoadStateListener { loadState ->
            val errorState = loadState.append as? LoadState.Error
                ?: loadState.prepend as? LoadState.Error

            showErrorAlert(errorState)
        }
    }

    private fun showErrorAlert(errorState: LoadState.Error?) {
        errorState?.let { error ->
            AlertDialog.Builder(context)
                .setTitle("에러")
                .setMessage(error.error.localizedMessage)
                .setNegativeButton("취소") { dialog, _ ->
                    dialog.dismiss()
                }
                .setPositiveButton("재시도") { _, _ ->
                    imageListAdapter.retry()
                }
                .show()
        }
    }
}