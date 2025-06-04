package com.oleg.sokolov.search.ui.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oleg.sokolov.search.ui.components.MovieCard
import com.oleg.sokolov.search.ui.model.SearchMovie
import com.oleg.sokolov.theme.MoviesArchTheme
import com.oleg.sokolov.theme.bold

@ExperimentalFoundationApi
@Composable
fun SearchMoviesListView(movies: List<SearchMovie>) {
  LazyColumn(
    content = {
      item {
        Text(
          modifier = Modifier.fillMaxWidth().padding(16.dp),
          text = "Search result (${movies.size})",
          style = MoviesArchTheme.typography.subtitle1.bold,
          textAlign = TextAlign.Start,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis,
          color = MoviesArchTheme.colors.primaryText
        )
      }
      movies.forEach {
        item {
          MovieCard(movie = it, modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp))
        }
      }
    }
  )
}

@ExperimentalFoundationApi
@Composable
@Preview
fun SearchMoviesListViewPreview() {
  MoviesArchTheme(darkTheme = false) {
    SearchMoviesListView(
      listOf(
        SearchMovie(
          id = 1,
          title = "Spider-man 3",
          thumbnail = "https://uakino.club/uploads/mini/poster/bd/add41ca1749c56e86420d94d75b009.jpg",
          overview = "overview",
          rating = 7.7f,
          voteCount = 100,
          releaseDate = "12/12/2021"
        ),
        SearchMovie(
          id = 1,
          title = "Spider-man 3",
          thumbnail = "https://uakino.club/uploads/mini/poster/bd/add41ca1749c56e86420d94d75b009.jpg",
          overview = "overview",
          rating = 7.7f,
          voteCount = 100,
          releaseDate = "12/12/2021"
        ),
        SearchMovie(
          id = 1,
          title = "Spider-man 3",
          thumbnail = "https://uakino.club/uploads/mini/poster/bd/add41ca1749c56e86420d94d75b009.jpg",
          overview = "overview",
          rating = 7.7f,
          voteCount = 100,
          releaseDate = "12/12/2021"
        ),
      )
    )
  }
}