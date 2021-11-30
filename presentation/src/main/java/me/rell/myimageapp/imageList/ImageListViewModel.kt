package me.rell.myimageapp.imageList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.rxjava2.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Observable
import me.rell.domain.GetImageListUseCase
import me.rell.domain.ImageDomainItem
import me.rell.myimageapp.base.BaseViewModel
import me.rell.myimageapp.utils.ResponseResult
import me.rell.myimageapp.utils.rx.toAndroidAsync
import javax.inject.Inject

@HiltViewModel
class ImageListViewModel @Inject constructor(
    private val getImageListUseCase: GetImageListUseCase
) : BaseViewModel() {

    private val _pagingDataResponse = MutableLiveData<ResponseResult<PagingData<ImageDomainItem>>>()
    val pagingImageDomainData: LiveData<ResponseResult<PagingData<ImageDomainItem>>>
        get() = _pagingDataResponse

    init {
        loadImageData()
    }

    private fun loadImageData() {
        getImageList()
            .toAndroidAsync()
            .subscribe({
                _pagingDataResponse.value = ResponseResult.Success(it)
            }, { e ->
                _pagingDataResponse.value = ResponseResult.Fail(e)
            })
            .disposeOnClear()
    }

    private fun getImageList(): Observable<PagingData<ImageDomainItem>> {
        return getImageListUseCase().cachedIn(viewModelScope)
    }
}