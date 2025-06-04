package com.oleg.sokolov.search.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.oleg.sokolov.search.domain.SearchFeature
import com.oleg.sokolov.search.ui.components.SearchBar
import com.oleg.sokolov.search.ui.view.SearchEmptyView
import com.oleg.sokolov.search.ui.view.SearchMoviesListView
import com.oleg.sokolov.tea.android.TeaViewModel
import com.oleg.sokolov.theme.MoviesArchTheme
import org.threeten.bp.LocalTime


@ExperimentalFoundationApi
@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    viewModel: TeaViewModel<SearchFeature.State, SearchFeature.Message, SearchFeature.Dependencies>,
    state: SearchFeature.State
) {

  Surface(
    color = MoviesArchTheme.colors.primaryBackground
  ) {
    Column {
      Box {
        SearchBar(
          modifier = modifier.padding(horizontal = 16.dp).padding(top = 24.dp, bottom = 8.dp),
          text = state.searchText,
          isLoading = state.loading,
          onClearTextClicked = {
            viewModel.dispatch(SearchFeature.Message.ClearSearch)
          },
          onSearchTextChanged = {
            viewModel.dispatch(SearchFeature.Message.SearchUpdated(it, LocalTime.now()))
          }
        )
      }
      when (state.moviesState) {
        is SearchFeature.MoviesResultState.MoviesEmpty -> SearchEmptyView(message = state.moviesState.message)
        is SearchFeature.MoviesResultState.MoviesError -> SearchEmptyView(message = state.moviesState.message)
        is SearchFeature.MoviesResultState.MoviesNotFound -> SearchEmptyView(message = state.moviesState.message)
        is SearchFeature.MoviesResultState.MoviesList -> SearchMoviesListView(movies = state.moviesState.movies)
      }
    }

  }


}


