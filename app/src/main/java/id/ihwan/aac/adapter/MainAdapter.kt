package id.ihwan.aac.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import id.ihwan.aac.R
import id.ihwan.aac.databinding.ItemMovieBinding
import id.ihwan.aac.model.Movie
import id.ihwan.aac.viewmodel.ItemMovieViewModel

class MainAdapter(val context: Context): RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    protected var movies: MutableList<Movie> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemMovieBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_movie, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[holder.adapterPosition])
    }


    fun setData(movie: MutableList<Movie>){
        this.movies = movie
    }

    class ViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(model: Movie){
            val viewModel = ItemMovieViewModel(model)
            binding.itemMovie = viewModel

        }
    }
}