package me.rell.myimageapp.imageList

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Observable

@HiltViewModel
class ImageListViewModel : ViewModel() {

    fun observeImageList(): Observable<List<ImageListItem>> {
        // fixme test code
        return Observable.just(arrayListOf(ImageListItem("https://images.unsplash.com/photo-1633114129669-78b1ff09902b?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyNzg0NzV8MXwxfGFsbHwxfHx8fHx8Mnx8MTYzODAwMDY0Mg&ixlib=rb-1.2.1&q=80&w=400")))
    }
}