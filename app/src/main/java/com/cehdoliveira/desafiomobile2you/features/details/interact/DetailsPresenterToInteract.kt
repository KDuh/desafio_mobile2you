package com.cehdoliveira.desafiomobile2you.features.details.interact

import android.content.Context
import com.cehdoliveira.desafiomobile2you.storage.entity.MovieEntity
import com.cehdoliveira.desafiomobile2you.api.model.similar.SimilarMovie


interface DetailsPresenterToInteract {
    val context: Context

    fun didFinishFetchSimilarMoviesOnAPI(
        movie: MovieEntity,
        similarMovies: MutableList<SimilarMovie>
    )
    fun didFinishFetchMovieOnAPI(movie: MovieEntity)
    fun didFinishHandleLike(like: Boolean)
    fun didFetchLikeOnStorage(like: Boolean)
    fun didFinishFetchMovieOnAPIWithError()
    fun requestUpdateLikes(likes: Int)
}