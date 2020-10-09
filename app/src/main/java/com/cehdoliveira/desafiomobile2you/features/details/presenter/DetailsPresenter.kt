package com.cehdoliveira.desafiomobile2you.features.details.presenter

import android.content.Context
import com.cehdoliveira.desafiomobile2you.storage.entity.MovieEntity
import com.cehdoliveira.desafiomobile2you.api.model.similar.SimilarMovie
import com.cehdoliveira.desafiomobile2you.features.details.interact.DetailsInteract
import com.cehdoliveira.desafiomobile2you.features.details.interact.DetailsInteractToPresenter
import com.cehdoliveira.desafiomobile2you.features.details.interact.DetailsPresenterToInteract

class DetailsPresenter(private val view: DetailsViewToPresenter) : DetailsPresenterToView,
    DetailsPresenterToInteract {

    override val context: Context get() = view.context

    private val interact: DetailsInteractToPresenter by lazy {
        DetailsInteract(this)
    }

    override fun onCreate() {
        view.initializeViews()
    }

    override fun onResume() {
        interact.fetchData()
        interact.fetchLikeOnStorage()
    }

    override fun imageLikeTapped() {
        interact.handleLike()
    }

    override fun requestUpdateLikesOnView(likes: Int) {
        view.updateLikes("$likes")
    }

    override fun didFinishHandleLike(like: Boolean) {
        when(like) {
            true -> view.renderImageLikeFill()
            else -> view.renderImageLikeDefault()
        }
    }

    override fun didFinishFetchMovieOnAPI(movie: MovieEntity) {
        val path = movie.poster
        val likes = "${movie.likes}"
        val views = "${movie.views}"
        view.showDetailsOfMovie(path, likes, views)
    }

    override fun didFinishFetchSimilarMoviesOnAPI(movie: MovieEntity, similarMovies: MutableList<SimilarMovie>) {
        val path = movie.poster
        val likes = "${movie.likes}"
        val views = "${movie.views}"
        view.showDetailsOfMovie(path, likes, views)
        view.postSimilarMovies(similarMovies)
    }

    override fun didFinishFetchMovieOnAPIWithError() {
        view.showDetailsOfMovieWithError()
    }

    override fun didFetchLikeOnStorage(like: Boolean) {
        if(like) {
            view.renderImageLikeFill()
        } else {
            view.renderImageLikeDefault()
        }
    }

}