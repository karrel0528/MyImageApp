package me.rell.myimageapp.imageList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.rxjava2.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Observable
import me.rell.domain.GetImageListUseCase
import me.rell.domain.ImageDomainItem
import javax.inject.Inject

@HiltViewModel
class ImageListViewModel @Inject constructor(
    private val getImageListUseCase: GetImageListUseCase
) : ViewModel() {

    fun observePagingImages(): Observable<PagingData<ImageDomainItem>> {
        return getImageListUseCase().cachedIn(viewModelScope)
    }
}