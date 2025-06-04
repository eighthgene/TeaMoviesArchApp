package com.oleg.sokolov.genre.data.repositories

import android.util.Log
import com.oleg.sokolov.api.genre.data.GenreRepository
import com.oleg.sokolov.api.genre.model.Genre
import com.oleg.sokolov.api.genre.model.Genre.Companion.CACHE_KEY
import com.oleg.sokolov.core.data.ListCache
import com.oleg.sokolov.core.data.Try
import com.oleg.sokolov.core.data.cacheWith
import com.oleg.sokolov.genre.data.api.GenreApi
import com.oleg.sokolov.network.model.ServiceConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext

class GenreRepositoryImpl(
  private val cache: ListCache<Genre>,
  private val genreApi: GenreApi,
  private val config: ServiceConfig
) : GenreRepository {

  override suspend fun loadGenres(): Try<List<Genre>> =
    cache[CACHE_KEY]?.value?.let {
      Try.Success(it)
    } ?: run {
      loadGenresFromNetwork()
    }

  @OptIn(FlowPreview::class)
  private suspend fun loadGenresFromNetwork(): Try<List<Genre>> {
    return try {
      Try.Success(
        withContext(Dispatchers.IO) {
          flowOf(
            genreApi.movieGenre(config.apiKey)
          )
        }
          .flowOn(Dispatchers.IO)
          .map { it.genres }
          .onEach { cache.save(CACHE_KEY.cacheWith(it)) }
          .onEach { Log.d(GenreRepositoryImpl::class.java.name, it.toString()) }
          .flatMapMerge { it.asFlow() }
          .toList()
      )
    } catch (ex: Exception) {
      Try.Failure(ex)
    }
  }

}