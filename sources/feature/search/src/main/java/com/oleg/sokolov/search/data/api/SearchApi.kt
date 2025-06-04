package com.oleg.sokolov.search.data.api

import com.oleg.sokolov.common.models.movie.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Movies api of themoviedb.org
 */
interface SearchApi {

  @GET("search/movie")
  suspend fun searchMovie(
      @Query("api_key") apiKey: String,
      @Query("query") query: String,
      @Query("page") page: Int = 1
  ): MovieResponse

}
