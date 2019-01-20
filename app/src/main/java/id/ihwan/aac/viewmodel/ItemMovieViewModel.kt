package id.ihwan.aac.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import id.ihwan.aac.model.Movie

class ItemMovieViewModel(model: Movie): ViewModel() {
    var title: ObservableField<String> = ObservableField()
    var overview: ObservableField<String> = ObservableField()
    var poster: ObservableField<String> = ObservableField()
    var date: ObservableField<String> = ObservableField()


    init {
        title.set(model.title)
        overview.set(model.overview)
        poster.set(model.poster_path)
        date.set(model.release_date)

    }
}