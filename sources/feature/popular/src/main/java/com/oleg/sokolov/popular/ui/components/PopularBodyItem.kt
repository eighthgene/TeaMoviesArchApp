package com.oleg.sokolov.popular.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer
import com.oleg.sokolov.common.models.movie.Movie
import com.oleg.sokolov.popular.R
import com.oleg.sokolov.theme.MoviesArchTheme

@OptIn(ExperimentalCoilApi::class)
@Composable
fun PopularBodyItem(
  movie: Movie,
  modifier: Modifier = Modifier
) {
  val loading = remember { mutableStateOf(true) }

  val painter = rememberImagePainter(
    data = movie.thumbnail,
    builder = {
      error(R.drawable.ic_cinema_grey_100)
    }

  )

  when (painter.state) {
    is ImagePainter.State.Success -> loading.value = false
    else -> {}
  }

  Card(
    modifier = modifier
      .width(200.dp)
      .height(350.dp),
    backgroundColor = MoviesArchTheme.colors.secondaryBackground,
    elevation = 2.dp
  ) {
    Column {
      Image(
        modifier = Modifier
          .fillMaxWidth()
          .weight(1f)
          .placeholder(
            color = MoviesArchTheme.colors.secondaryBackground,
            visible = loading.value,
            highlight = PlaceholderHighlight.shimmer(highlightColor = MoviesArchTheme.colors.primaryTextHint)
          ),
        contentScale = ContentScale.Crop,
        painter = painter,
        contentDescription = null,
      )

      Text(
        modifier = Modifier
          .padding(8.dp)
          .fillMaxWidth()
          .placeholder(
            color = MoviesArchTheme.colors.secondaryBackground,
            visible = loading.value,
            highlight = PlaceholderHighlight.shimmer(highlightColor = MoviesArchTheme.colors.primaryTextHint)
          ),
        text = movie.title,
        textAlign = TextAlign.Center,
        maxLines = 1,
        color = MoviesArchTheme.colors.primaryText
      )
    }

  }
}


@Composable
@Preview
fun MovieCardPreviewDark() {
  MoviesArchTheme(darkTheme = true) {
    //PopularBodyItem(PreviewProvider.movie)
  }
}

@Composable
@Preview
fun MovieCardPreviewWhite() {
  MoviesArchTheme(darkTheme = false) {
    //PopularBodyItem(PreviewProvider.movie)
  }
}