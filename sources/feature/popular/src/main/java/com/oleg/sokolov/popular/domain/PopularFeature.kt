package com.oleg.sokolov.popular.domain

import com.oleg.sokolov.common.models.common.ui.Text
import com.oleg.sokolov.common.models.movie.Movie
import com.oleg.sokolov.core.data.Try
import com.oleg.sokolov.popular.R
import com.oleg.sokolov.popular.data.repositories.PopularMoviesRepository
import com.oleg.sokolov.tea.Command
import com.oleg.sokolov.tea.Update
import com.oleg.sokolov.tea.noCommands
import com.oleg.sokolov.tea.with

object PopularFeature {

  data class State(
    val loading: Boolean,
    val moviesState: MoviesResultState
  )

  sealed class MoviesResultState {
    data class MoviesList(val searchMovies: List<Movie>) : MoviesResultState()
    data class MoviesEmpty(val message: Text) : MoviesResultState()
    data class MoviesNotFound(val message: Text) : MoviesResultState()
    data class MoviesError(val message: Text) : MoviesResultState()
  }

  sealed class Message {
    // system
    data class MoviesResponse(val response: Try<List<Movie>>) : Message()
  }

  object Logic {
    private val initialState = State(
      loading = true,
      moviesState = MoviesResultState.MoviesEmpty(Text.ResText(R.string.popular_placeholder))
    )
    val initialUpdate = initialState with Commands.GetPopularMovies

    fun update(message: Message, state: State): Update<State, Message, Dependencies> =
      when(message){
        is Message.MoviesResponse -> handleMoviesResponse(message.response, state)
      }

    private fun handleMoviesResponse(response: Try<List<Movie>>, state: State): Update<State, Message, Dependencies> =
      when(response){
        is Try.Failure -> state.copy(loading = false, moviesState = MoviesResultState.MoviesError(
            Text.ResText(R.string.popular_error)
        )
        ) with noCommands()
        is Try.Success -> state.copy(loading = false, moviesState = MoviesResultState.MoviesList(
            response.value
        )
        ) with noCommands()
      }

  }

  object Commands {
    object GetPopularMovies : Command<Dependencies, Message> by Command.single({ deps ->
      val popular = deps.repository.popularMovies()
      return@single Message.MoviesResponse(popular)
    })
  }

  class Dependencies(
    val repository: PopularMoviesRepository
  )
}