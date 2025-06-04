package com.oleg.sokolov.search.domain

import com.oleg.sokolov.api.genre.data.GenreRepository
import com.oleg.sokolov.api.genre.model.Genre
import com.oleg.sokolov.common.models.common.ui.Text
import com.oleg.sokolov.common.models.movie.Movie
import com.oleg.sokolov.core.data.Try
import com.oleg.sokolov.search.R
import com.oleg.sokolov.search.data.SearchMoviesRepository
import com.oleg.sokolov.search.ui.model.SearchMovie
import com.oleg.sokolov.tea.Command
import com.oleg.sokolov.tea.Update
import com.oleg.sokolov.tea.noCommands
import com.oleg.sokolov.tea.with
import org.threeten.bp.Duration
import org.threeten.bp.LocalTime


object SearchFeature {

  //TODO 1
  data class State(
    val searchText: String,
    val loading: Boolean = false,
    val lastRequestTime: LocalTime,
    val moviesState: MoviesResultState
  )

  sealed class MoviesResultState {
    data class MoviesList(val movies: List<SearchMovie>) : MoviesResultState()
    data class MoviesEmpty(val message: Text) : MoviesResultState()
    data class MoviesNotFound(val message: Text) : MoviesResultState()
    data class MoviesError(val message: Text) : MoviesResultState()
  }

  //TODO 2
  sealed class Message {
    // user
    data class SearchUpdated(val query: String, val time: LocalTime) : Message()
    object ClearSearch : Message()

    // system
    data class MoviesResponse(val response: Try<List<Movie>>) : Message()
    data class GenresResponse(val movies: List<Movie>, val response: Try<List<Genre>>) : Message()
  }

  object Logic {
    private val initialState = State(
      searchText = "",
      lastRequestTime = LocalTime.MIN,
      moviesState = MoviesResultState.MoviesEmpty(Text.ResText(R.string.search_placeholder))
    )

    val initialUpdate = initialState with noCommands<Message, Dependencies>()

    //TODO 3
    fun update(message: Message, state: State): Update<State, Message, Dependencies> =
      when (message) {
        is Message.SearchUpdated -> handleSearchUpdate(message.query, message.time, state)
        is Message.MoviesResponse -> handleMoviesResponse(message.response, state)
        is Message.GenresResponse -> handleGenreResponse(message.movies, message.response, state)
        Message.ClearSearch -> handleClearSearch(state)
      }

    private fun handleClearSearch(state: State): Update<State, Message, Dependencies> =
      state.copy(
        searchText = "",
        loading = false,
        moviesState = MoviesResultState.MoviesEmpty(Text.ResText(R.string.search_placeholder))
      ) with noCommands()

    private fun handleGenreResponse(
      movies: List<Movie>,
      genres: Try<List<Genre>>,
      state: State
    ): Update<State, Message, Dependencies> =
      when (genres) {
        is Try.Failure -> state.copy(moviesState = MoviesResultState.MoviesList(movies = movies.map {
          SearchMovie(
            it,
            emptyList()
          )
        }), loading = false) with noCommands()
        is Try.Success -> state.copy(moviesState = MoviesResultState.MoviesList(movies = movies.map {
          genres.value.mapWithGenres(
            it
          )
        }), loading = false) with noCommands()
      }

    private fun List<Genre>.mapWithGenres(movie: Movie) =
      SearchMovie(movie, this.filter {
        movie.genresId.contains(it.id)
      })

    private fun handleMoviesResponse(
      response: Try<List<Movie>>,
      state: State
    ): Update<State, Message, Dependencies> =
      when (response) {
        is Try.Failure -> state.copy(
          searchText = state.searchText,
          loading = false,
          moviesState = MoviesResultState.MoviesError(Text.ResText(R.string.search_error))
        ) with noCommands()
        is Try.Success -> {
          if (response.value.isEmpty()) {
            state.copy(
              moviesState = MoviesResultState.MoviesNotFound(Text.ResText(R.string.search_not_found_movies)),
              loading = false
            )
          } else {
            state.copy(loading = true)
          } with Commands.GetGenres(response.value)
        }
      }

    private fun handleSearchUpdate(
      query: String,
      currentTime: LocalTime,
      state: State
    ): Update<State, Message, Dependencies> {
      return when {
        query.isEmpty() -> return state.copy(
          searchText = query,
          moviesState = MoviesResultState.MoviesEmpty(Text.ResText(R.string.search_placeholder)),
          loading = false,
        ) with noCommands()
        Duration.between(state.lastRequestTime, currentTime).toMillis() < 500 -> {
          state.copy(searchText = query) with noCommands()
        }
        else -> {
          state.copy(
            searchText = query,
            lastRequestTime = currentTime,
            moviesState = state.moviesState,
            loading = true,
          ) with Commands.GetMovies(query)
        }
      }
    }
  }

  //TODO 5
  object Commands {
    data class GetMovies(val query: String) : Command<Dependencies, Message> by Command.onIO.single({ deps ->
        val movies = deps.searchMoviesRepository.searchMovies(query)
        return@single Message.MoviesResponse(movies)
      })

    data class GetGenres(val movies: List<Movie>) : Command<Dependencies, Message> by Command.onIO.single({ deps ->
        val genres = deps.genreRepository.loadGenres()
        return@single Message.GenresResponse(movies, genres)
      })
  }

  //TODO 6
  class Dependencies(
      val searchMoviesRepository: SearchMoviesRepository,
      val genreRepository: GenreRepository
  )

}


