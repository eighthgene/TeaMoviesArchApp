package com.oleg.sokolov.search.ui.model

import com.oleg.sokolov.api.genre.model.Genre

object PreviewProvider {

  val movie = SearchMovie(
    id = 1,
    title = "Spider-man 3 Reborn Line Long Long Spider",
    thumbnail = "https://uakino.club/uploads/mini/poster/bd/add41ca1749c56e86420d94d75b009.jpg",
    overview = "A dog goes on quest to discover his purpose in life over the course of several lifetimes with multiple owners.",
    rating = 7.7f,
    releaseDate = "12/12/2021",
    voteCount = 100,
    adult = true,
    genres  = listOf(
      Genre(1, "Action"),
      Genre(2, "Comedy"),
      Genre(3, "Drama"),
      Genre(3, "Drama"),
      Genre(3, "Drama"),
      Genre(3, "Drama"),
      Genre(3, "Drama"),
      Genre(3, "Drama"),
      Genre(3, "Drama"),
      Genre(3, "Drama"),
      Genre(3, "Drama"),
      Genre(3, "Drama"),
      Genre(3, "Drama"),
      Genre(3, "Drama"),
      Genre(3, "Drama"),
    ),

  )

  val moviesList = listOf(
    SearchMovie(
      id = 1,
      title = "Spider-man 3",
      thumbnail = "https://uakino.club/uploads/mini/poster/bd/add41ca1749c56e86420d94d75b009.jpg",
      overview = "A dog goes on quest to discover his purpose in life over the course of several lifetimes with multiple owners.",
      rating = 7.7f,
      voteCount = 100,
      releaseDate = "12/12/2021"
    ),
    SearchMovie(
      id = 1,
      title = "Spider-man 3",
      thumbnail = "https://uakino.club/uploads/mini/poster/bd/add41ca1749c56e86420d94d75b009.jpg",
      overview = "A dog goes on quest to discover his purpose in life over the course of several lifetimes with multiple owners.",
      rating = 7.7f,
      voteCount = 100,
      releaseDate = "12/12/2021"
    ),
    SearchMovie(
      id = 1,
      title = "Spider-man 3",
      thumbnail = "https://uakino.club/uploads/mini/poster/bd/add41ca1749c56e86420d94d75b009.jpg",
      overview = "A dog goes on quest to discover his purpose in life over the course of several lifetimes with multiple owners.",
      rating = 7.7f,
      voteCount = 100,
      releaseDate = "12/12/2021"
    )
  )

}