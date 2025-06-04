package com.oleg.sokolov.api.genre.data

import com.oleg.sokolov.api.genre.model.Genre
import com.oleg.sokolov.core.data.Try

interface GenreRepository {

    suspend fun loadGenres(): Try<List<Genre>>


}