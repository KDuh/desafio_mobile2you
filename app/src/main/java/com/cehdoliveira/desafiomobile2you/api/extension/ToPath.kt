package com.cehdoliveira.desafiomobile2you.api.extension

fun String.createImagePath() : String {

    return "https://image.tmdb.org/t/p/w500/${this}"

}