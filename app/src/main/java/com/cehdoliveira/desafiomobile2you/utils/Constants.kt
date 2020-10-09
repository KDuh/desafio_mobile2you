package com.cehdoliveira.desafiomobile2you.utils

import com.cehdoliveira.desafiomobile2you.BuildConfig

class Constants {

    companion object {
        const val END_POINT_MOVIES = "movie/{id}"
        const val END_POINT_SIMILAR_MOVIES = "movie/{movie_id}/similar"
        const val PATH_ID = "id"
        const val PATH_MOVIE_ID = "movie_id"
        const val QUERY_API_KEY = "api_key"
        const val QUERY_LANGUAGE = "language"
        const val API_KEY = BuildConfig.API_KEY
        const val ID_MOVIE = 157336
        const val PORTUGUES = "pt_BR"
    }

}