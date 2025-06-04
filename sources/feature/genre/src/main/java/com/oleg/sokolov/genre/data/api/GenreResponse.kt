package com.oleg.sokolov.genre.data.api

import com.google.gson.annotations.SerializedName
import com.oleg.sokolov.api.genre.model.Genre

data class GenreResponse(
  @SerializedName("genres")
  val genres: List<Genre>
)