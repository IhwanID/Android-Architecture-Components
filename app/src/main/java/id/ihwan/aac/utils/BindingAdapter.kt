package id.ihwan.aac.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

class BindingAdapter {

    companion object {
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(imageView: ImageView, url: String){
            Picasso.get().load("https://image.tmdb.org/t/p/w500/"+ url).into(imageView)
        }

    }
}