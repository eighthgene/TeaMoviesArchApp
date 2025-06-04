package com.oleg.sokolov.popular.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.pager.ExperimentalPagerApi
import com.oleg.sokolov.common.extentions.verticalGradientBackground
import com.oleg.sokolov.popular.domain.PopularFeature
import com.oleg.sokolov.popular.ui.components.PopularBody
import com.oleg.sokolov.popular.ui.components.PopularBodyMessage
import com.oleg.sokolov.popular.ui.components.PopularHeader
import com.oleg.sokolov.popular.ui.components.PopularLoading
import com.oleg.sokolov.tea.android.TeaViewModel
import com.oleg.sokolov.theme.MoviesArchTheme


@Composable
fun getGradient(): List<Color> {
  return listOf(
    MoviesArchTheme.colors.primaryBackground,
    MoviesArchTheme.colors.accentColor,
    MoviesArchTheme.colors.primaryBackground
  )
}

@ExperimentalPagerApi
@Composable
fun PopularScreen(
    viewModel: TeaViewModel<PopularFeature.State, PopularFeature.Message, PopularFeature.Dependencies>,
    state: PopularFeature.State
) {

  Column(
    modifier = Modifier
      .fillMaxSize()
      .verticalGradientBackground(getGradient()),
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {

    PopularHeader()

    when (state.loading) {
      true -> PopularLoading()
      false -> when (state.moviesState) {
        is PopularFeature.MoviesResultState.MoviesEmpty -> PopularBodyMessage(message = state.moviesState.message)
        is PopularFeature.MoviesResultState.MoviesError -> PopularBodyMessage(message = state.moviesState.message)
        is PopularFeature.MoviesResultState.MoviesList ->  PopularBody(movies = state.moviesState.searchMovies)
        is PopularFeature.MoviesResultState.MoviesNotFound -> PopularBodyMessage(message = state.moviesState.message)
      }
    }


  }
}

