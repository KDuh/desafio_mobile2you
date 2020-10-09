package com.cehdoliveira.desafiomobile2you.api.repository

import com.cehdoliveira.desafiomobile2you.api.OnGetMoviesDetailsCallback
import com.cehdoliveira.desafiomobile2you.api.OnGetSimilarMoviesDetailsCallback


interface InteractToApi {

    fun getMoviesDetails(callbackMoviesDetails: OnGetMoviesDetailsCallback)
    fun getSimilarMovies(callbackSimilarMovies: OnGetSimilarMoviesDetailsCallback)

}