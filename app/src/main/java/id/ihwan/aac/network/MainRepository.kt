package id.ihwan.aac.network

import id.ihwan.aac.model.MovieResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainRepository {
    private val apiService = ApiFactory.create()
    private val compositeDisposable = CompositeDisposable()

    fun requestMovie(onResult: (MovieResponse) -> Unit, onError: (Throwable) -> Unit){
        apiService.getMovie()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: ApiObserver<MovieResponse>(compositeDisposable){
                override fun onApiSuccess(data: MovieResponse) {
                    onResult(data)
                }

                override fun onApiError(er: Throwable) {
                    onError(er)
                }
            })
    }

    fun onDestroy(){
        compositeDisposable.clear()
    }
}