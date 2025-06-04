package com.oleg.sokolov.api.genre

import com.oleg.sokolov.api.genre.data.GenreRepository

interface GenreFeatureApi {

    fun genreRepository() : GenreRepository

}