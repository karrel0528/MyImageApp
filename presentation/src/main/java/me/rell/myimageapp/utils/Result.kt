package me.rell.myimageapp.utils

sealed class ResponseResult<T> {
    class Success<T>(val data: T) : ResponseResult<T>()
    class Fail<T>(val e: Throwable) : ResponseResult<T>()  // crashlytics 연결 시 사용.
}