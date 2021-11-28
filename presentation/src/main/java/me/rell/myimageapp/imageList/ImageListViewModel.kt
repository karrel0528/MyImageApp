package me.rell.myimageapp.imageList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava2.cachedIn
import androidx.paging.rxjava2.observable
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Observable
import me.rell.domain.GetImageListUseCase
import me.rell.myimageapp.imageList.adapter.ImageListItem
import javax.inject.Inject

@HiltViewModel
class ImageListViewModel @Inject constructor(
    private val getImageListUseCase: GetImageListUseCase
) : ViewModel() {

    fun observePagingImages(): Observable<PagingData<ImageListItem>> {
        return Pager(
            config = PagingConfig(QUERY_PAGE_SIZE),
            pagingSourceFactory = { ImageListPagingSource(getImageListUseCase) }
        ).observable.cachedIn(viewModelScope)
    }

    companion object {
        private const val QUERY_PAGE_SIZE = 10
    }
}