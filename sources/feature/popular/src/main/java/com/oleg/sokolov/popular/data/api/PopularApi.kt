package com.oleg.sokolov.popular.data.api

import com.oleg.sokolov.common.models.movie.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PopularApi {

  @GET("movie/popular")
  suspend fun popularMovie(
    @Query("api_key") apiKey: String,
    @Query("page") page: Int = 1
  ): MovieResponse

}