package com.oleg.sokolov.genre.data.api

import retrofit2.http.GET
import retrofit2.http.Query

interface GenreApi {

  @GET("genre/movie/list")
  suspend fun movieGenre(
    @Query("api_key") apiKey: String,
  ): GenreResponse


}