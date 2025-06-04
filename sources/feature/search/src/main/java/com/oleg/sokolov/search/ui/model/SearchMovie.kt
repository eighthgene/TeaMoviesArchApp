package com.oleg.sokolov.search.ui.model

import com.oleg.sokolov.api.genre.model.Genre
import com.oleg.sokolov.common.models.movie.Movie


data class SearchMovie(
  val id: Int,
  val title: String,
  val overview: String,
  val thumbnail: String?,
  val rating: Float,
  val adult: Boolean = false,
  val voteCount: Int,
  val releaseDate: String?,
  val genres: List<Genre> = emptyList()
) {
  constructor(movie: Movie, genres: List<Genre>) : this(
    id = movie.id,
    title = movie.title,
    overview = movie.overview,
    thumbnail = movie.thumbnail,
    rating = movie.rating.toFloat(),
    adult = movie.adult,
    voteCount = movie.voteCount,
    releaseDate = movie.releaseDate,
    genres = genres
  )
}