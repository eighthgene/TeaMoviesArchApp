package com.oleg.sokolov.common.models.movie

import com.google.gson.annotations.SerializedName

/**
 * Class of Movies coming from the api
 */
data class MovieEntity(

  @SerializedName("poster_path")
  val posterPath: String?,

  @SerializedName("id")
  val id: Int,

  @SerializedName("adult")
  val adult: Boolean?,

  @SerializedName("title")
  val title: String,

  @SerializedName("vote_average")
  val rating: Double?,

  @SerializedName("vote_count")
  val voteCount: Int?,

  @SerializedName("genre_ids")
  val genres: List<Int>?,

  @SerializedName("release_date")
  val releaseDate: String?,

  @SerializedName("overview")
  val overview: String,

)
