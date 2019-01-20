package id.ihwan.aac.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import id.ihwan.aac.model.MovieResponse
import id.ihwan.aac.network.MainRepository

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val repository = MainRepository()

    var movies : MutableLiveData<MovieResponse> = MutableLiveData()
    var error: MutableLiveData<Throwable> = MutableLiveData()

    fun getMovie(){
        repository.requestMovie({
            movies.postValue(it)
        },{
            error.postValue(it)
        })
    }

    override fun onCleared() {
        super.onCleared()
        repository.onDestroy()
    }
}