package com.alif.basemvvm.base

import io.reactivex.observers.DisposableObserver
import java.io.IOException
import java.util.concurrent.TimeoutException

abstract class BaseResponse<T> : DisposableObserver<T>() {
    override fun onNext(response: T) {
        onSuccess(response)
    }

    override fun onComplete() {
    }

    override fun onError(e: Throwable) {
        when (e) {
            is IOException -> onNoInternetConnection()
            is TimeoutException -> onTimeout()
            else -> onUnknownError(e.message?: "Unknown error")
        }
    }

    abstract fun onSuccess(response : T)
    abstract fun onNoInternetConnection()
    abstract fun onTimeout()
    abstract fun onUnknownError(message: String)

}