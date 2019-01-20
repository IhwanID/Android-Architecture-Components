package id.ihwan.aac.network

import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class ApiObserver<T> constructor(private val compositeDisposable: CompositeDisposable): Observer<T> {
    override fun onComplete() {

    }

    override fun onSubscribe(d: Disposable) {
        compositeDisposable.add(d)
    }

    override fun onNext(t: T) {
        onApiSuccess(t)
    }

    override fun onError(e: Throwable) {
        onApiError(e)
    }

    abstract fun onApiSuccess(data: T)
    abstract fun onApiError(er: Throwable)
}