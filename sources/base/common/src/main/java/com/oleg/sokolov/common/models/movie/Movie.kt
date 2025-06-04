package com.oleg.sokolov.common.models.movie

data class Movie(
  val id: Int,
  val title: String,
  val overview: String,
  val thumbnail: String?,
  val rating: Double,
  val adult: Boolean,
  val voteCount: Int,
  val genresId: List<Int>,
  val releaseDate: String?,
) {
  constructor(entity: MovieEntity, thumbnail: String?) : this(
    id = entity.id,
    title = entity.title,
    overview = entity.overview,
    thumbnail = thumbnail,
    rating = entity.rating ?: 0.0,
    adult = entity.adult ?: false,
    voteCount =  entity.voteCount ?: 0,
    genresId = entity.genres ?: emptyList(),
    releaseDate = entity.releaseDate
  )
}