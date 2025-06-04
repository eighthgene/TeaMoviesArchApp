package com.oleg.sokolov.popular.data.repositories

import android.util.Log
import com.oleg.sokolov.common.models.movie.Movie
import com.oleg.sokolov.common.models.movie.MovieEntity
import com.oleg.sokolov.core.data.Try
import com.oleg.sokolov.popular.data.api.PopularApi
import com.oleg.sokolov.network.model.ServiceConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext

/**
 * Repository providing data about [Movie]
 */
class PopularMoviesRepository(
    private val popularApi: PopularApi,
    private val config: ServiceConfig
) {

  @OptIn(FlowPreview::class)
  internal suspend fun popularMovies(page: Int = 1): Try<List<Movie>> {
    return try {
      Try.Success(
        withContext(Dispatchers.IO) {
          flowOf(
            popularApi.popularMovie(config.apiKey, page)
          )
        }
          .flowOn(Dispatchers.IO)
          .onEach { Log.d(PopularMoviesRepository::class.java.name, it.searchMovies.toString()) }
          .flatMapMerge { it.searchMovies.asFlow() }
          .map { Movie(it, getPosterUrl(it)) }
          .toList()
      )
    } catch (ex: Exception) {
      Try.Failure(ex)
    }
  }

  private fun getPosterUrl(it: MovieEntity) = "${config.baseImageUrl}${it.posterPath}"
}
