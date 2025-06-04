package com.oleg.sokolov.popular.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.oleg.sokolov.common.models.movie.Movie
import kotlin.math.absoluteValue

@ExperimentalPagerApi
@Composable
fun PopularBody(
  movies: List<Movie>
) {
  HorizontalPager(
    count = movies.size,
    modifier = Modifier.fillMaxSize(),
    contentPadding = PaddingValues(72.dp)
  ) { page ->
    Card(
      Modifier
        .graphicsLayer {
          // Calculate the absolute offset for the current page from the
          // scroll position. We use the absolute value which allows us to mirror
          // any effects for both directions
          val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

          // We animate the scaleX + scaleY, between 85% and 100%
          lerp(
            start = 0.85f,
            stop = 1.3f,
            fraction = 1f - pageOffset.coerceIn(0f, 1f)
          ).also { scale ->
            scaleX = scale
            scaleY = scale
          }

          // We animate the alpha, between 50% and 100%
          alpha = lerp(
            start = 0.5f,
            stop = 1f,
            fraction = 1f - pageOffset.coerceIn(0f, 1f)
          )
        }
    ) {
      // Card content
      PopularBodyItem(movie = movies[page], modifier = Modifier.padding(0.dp))
    }
  }
}