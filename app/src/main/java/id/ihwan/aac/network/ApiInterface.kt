package id.ihwan.aac.network

import id.ihwan.aac.model.MovieResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiInterface {
    @GET("upcoming?api_key=78adf61cd991fec888c055105c148a44")
    fun getMovie(): Observable<MovieResponse>
}