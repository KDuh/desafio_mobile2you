package com.cehdoliveira.desafiomobile2you.features.details.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.cehdoliveira.desafiomobile2you.R
import com.cehdoliveira.desafiomobile2you.utils.createImagePath
import com.cehdoliveira.desafiomobile2you.api.model.similar.SimilarMovie
import com.cehdoliveira.desafiomobile2you.utils.ToGenres
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movies.view.*

class SimilarMoviesAdapter(var similarMoviesList: MutableList<SimilarMovie>):
    RecyclerView.Adapter<SimilarMoviesAdapter.ViewHolder>(){

    companion object{
        const val TAG = "similar-adapter"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_movies))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(similarMoviesList, position)
    }

    override fun getItemCount() = similarMoviesList.size

    fun updateList(feeds: MutableList<SimilarMovie>) {
        this.similarMoviesList.clear()
        this.similarMoviesList.addAll(feeds)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        private var textTitle: TextView = itemView.itemMovies_textView_title
        private var textSubTitle: TextView = itemView.itemMovies_textView_subtitle
        private var imagePoster: ImageView = itemView.itemMovies_imageView_poster

        fun bind(similarMovie: MutableList<SimilarMovie>, position: Int){

            Log.d("adapter", "title: ${similarMovie[position].title} url: ${similarMovie[position].id}")
            textTitle.text = similarMovie[position].title
            textSubTitle.text = getGenre(similarMovie[position])
            val path = similarMovie[position].poster_path.createImagePath()
            Picasso
                .get()
                .load(path)
                .centerCrop()
                .fit()
                .error(R.drawable.ic_launcher_background)
                .into(imagePoster)

        }

        private fun getGenre(similarMovie: SimilarMovie) : String {
            val genreIds = similarMovie.genre_ids
            val year = similarMovie.release_date.subSequence(0, 4)
            var genres = ""
            genreIds.forEach {
                genres += "${ToGenres.invoke(it)}, "
            }
            return "$year ${genres.subSequence(0, genres.count() - 2)}"
        }

    }

}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}