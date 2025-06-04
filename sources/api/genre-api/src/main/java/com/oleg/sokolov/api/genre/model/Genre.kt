package com.oleg.sokolov.api.genre.model

data class Genre(
  val id: Int,
  val name: String
) {

  companion object {
    const val CACHE_KEY = "GENRE_CACHE_KEY"
  }
}
