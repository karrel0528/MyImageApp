/*
 * Copyright 2020 Hyperconnect inc. All rights reserved.
 *
 * Hyperconnect inc. intellectual property.
 * Use of this software is subject to licence terms.
 */
package me.rell.myimageapp.utils.rx

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.uber.autodispose.ObservableSubscribeProxy
import com.uber.autodispose.android.lifecycle.autoDisposable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.internal.functions.Functions
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

fun <T> Observable<T>.toAndroidAsync(): Observable<T> =
    this.subscribeOnIoThread()
        .observeOnMainThread()

fun <T> Observable<T>.toIoAsync(): Observable<T> =
    this.subscribeOn(Schedulers.io())
        .observeOn(Schedulers.io())

fun <T> Observable<T>.onPause(owner: LifecycleOwner): ObservableSubscribeProxy<T> {
    return autoDisposable(owner, Lifecycle.Event.ON_PAUSE)
}

fun <T> Observable<T>.onStop(owner: LifecycleOwner): ObservableSubscribeProxy<T> {
    return autoDisposable(owner, Lifecycle.Event.ON_STOP)
}

fun <T> Observable<T>.onDestroy(owner: LifecycleOwner): ObservableSubscribeProxy<T> {
    return autoDisposable(owner, Lifecycle.Event.ON_DESTROY)
}

fun <T> Observable<T>.subscribeEmptyConsume(): Disposable {
    return this.subscribe(Functions.emptyConsumer(), Functions.emptyConsumer())
}

inline fun <T> Observable<T>.subscribeEmptyError(crossinline onNext: (T) -> Unit): Disposable {
    return this.subscribe({ onNext.invoke(it) }, Timber::e)
}

fun <T> ObservableSubscribeProxy<T>.subscribeEmptyConsume(): Disposable {
    return this.subscribe(Functions.emptyConsumer(), Functions.emptyConsumer())
}

inline fun <T> ObservableSubscribeProxy<T>.subscribeEmptyError(crossinline onNext: (T) -> Unit): Disposable {
    return this.subscribe({ onNext.invoke(it) }, Timber::e)
}

fun <T> Observable<T>.observeOnMainThread(): Observable<T> = observeOn(AndroidSchedulers.mainThread())

fun <T> Observable<T>.subscribeOnIoThread(): Observable<T> = subscribeOn(Schedulers.io())

fun <T> Observable<T>.observeOnIoThread(): Observable<T> = observeOn(Schedulers.io())
