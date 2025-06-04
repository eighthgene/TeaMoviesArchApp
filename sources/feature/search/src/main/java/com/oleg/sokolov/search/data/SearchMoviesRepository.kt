package com.oleg.sokolov.search.data

import android.util.Log
import com.oleg.sokolov.common.models.movie.Movie
import com.oleg.sokolov.common.models.movie.MovieEntity
import com.oleg.sokolov.core.data.Try
import com.oleg.sokolov.network.model.ServiceConfig
import com.oleg.sokolov.search.data.api.SearchApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext

/**
 * Repository providing data about [Movie]
 */
class SearchMoviesRepository(
    private val config: ServiceConfig,
    private val searchApi: SearchApi
) {

    /**
     * Search [Movie]s for the given [query] string
     */
    @OptIn(FlowPreview::class)
    internal suspend fun searchMovies(query: String, page: Int = 1): Try<List<Movie>> {
        return try {
            Try.Success(
                withContext(Dispatchers.IO) {
                    flowOf(
                        searchApi.searchMovie(config.apiKey, query, page)
                    )
                }
                    .flowOn(Dispatchers.IO)
                    .onEach {
                        Log.d(
                            SearchMoviesRepository::class.java.name,
                            it.searchMovies.toString()
                        )
                    }
                    .flatMapMerge { it.searchMovies.asFlow() }
                    .map { Movie(it, getPosterUrl(it)) }
                    .toList())
        } catch (ex: Exception) {
            Try.Failure(ex)
        }
    }

    private fun getPosterUrl(it: MovieEntity) = "${config.baseImageUrl}${it.posterPath}"
}
