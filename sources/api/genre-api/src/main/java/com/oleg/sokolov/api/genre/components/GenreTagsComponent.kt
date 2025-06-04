package com.oleg.sokolov.api.genre.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowCrossAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment
import com.google.accompanist.flowlayout.SizeMode
import com.oleg.sokolov.api.genre.model.Genre
import com.oleg.sokolov.theme.MoviesArchTheme

@Composable
fun TagsComponent(
  modifier: Modifier = Modifier,
  genres: List<Genre>,
  limit: Int? = null
) {
  FlowRow(
    modifier = modifier,
    mainAxisAlignment = MainAxisAlignment.Start,
    mainAxisSize = SizeMode.Expand,
    crossAxisAlignment = FlowCrossAxisAlignment.Start,
    crossAxisSpacing = 4.dp,
    mainAxisSpacing = 4.dp
  ) {
    limit?.let {
      genres.take(it).forEach { genre ->
        GenreTag(genre.name)
      }
    } ?: run {
      genres.forEach { genre ->
        GenreTag(genre.name)
      }
    }

  }


}

@Composable
@Preview
fun PreviewTagsComponent() {
  MoviesArchTheme(darkTheme = false) {
    TagsComponent(
      modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight(),
      genres = listOf(
        Genre(1, "Action"),
        Genre(2, "Comedy"),
        Genre(3, "Drama"),
        Genre(3, "Drama"),
        Genre(3, "Drama"),
      )
    )
  }
}