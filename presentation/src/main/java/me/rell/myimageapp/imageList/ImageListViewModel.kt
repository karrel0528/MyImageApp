package me.rell.myimageapp.imageList

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Observable
import me.rell.domain.GetImageListUseCase
import javax.inject.Inject

@HiltViewModel
class ImageListViewModel @Inject constructor(
    private val getImageListUseCase: GetImageListUseCase
) : ViewModel() {

    fun observeImageList(): Observable<List<ImageListItem>> {
        return getImageListUseCase
            .get()
            .map { items ->
                items.map(ImageListItem::mapFromDomainItem)
            }
            .toObservable()
    }
}