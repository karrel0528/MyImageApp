package me.rell.myimageapp.base

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import me.rell.domain.ImageDomainItem

abstract class BaseViewModel : ViewModel() {
    private val disposables = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()

        disposables.dispose()
    }

    protected fun Disposable.disposeOnClear(): Disposable {
        disposables.add(this)
        return this
    }
}