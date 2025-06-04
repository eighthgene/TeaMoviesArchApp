package com.oleg.sokolov.search.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer
import com.oleg.sokolov.api.genre.components.TagsComponent
import com.oleg.sokolov.common.ratingbar.CustomRatingBar
import com.oleg.sokolov.common.ratingbar.RatingBarConfig
import com.oleg.sokolov.common.ratingbar.RatingBarStyle
import com.oleg.sokolov.search.R
import com.oleg.sokolov.search.ui.model.PreviewProvider
import com.oleg.sokolov.search.ui.model.SearchMovie
import com.oleg.sokolov.theme.MoviesArchTheme

@OptIn(ExperimentalCoilApi::class)
@Composable
fun MovieCard(
  movie: SearchMovie,
  modifier: Modifier = Modifier
) {
  val loading = remember { mutableStateOf(true) }

  val painter = rememberImagePainter(
    request = ImageRequest.Builder(LocalContext.current)
      .data(movie.thumbnail)
      .error(R.drawable.ic_cinema_grey_100)
      .build()
  )

  when (painter.state) {
    is ImagePainter.State.Success -> loading.value = false
    is ImagePainter.State.Error -> loading.value = false
    else -> {}
  }

  Box(
    modifier = modifier
      .fillMaxWidth()
      .wrapContentHeight()
      .background(Color.Transparent)
  ) {
    Row {
      Card(
        modifier = Modifier
          .height(170.dp)
          .fillMaxWidth()
          .align(alignment = Alignment.Bottom)
          .weight(1f),
        shape = RoundedCornerShape(topEnd = 8.dp, topStart = 8.dp, bottomStart = 8.dp),
        elevation = 8.dp
      ) {
        Image(
          modifier = Modifier
            .placeholder(
              color = MoviesArchTheme.colors.secondaryBackground,
              visible = loading.value,
              highlight = PlaceholderHighlight.shimmer(highlightColor = MoviesArchTheme.colors.primaryTextHint)
            ),
          contentScale = ContentScale.Crop,
          painter = painter,
          contentDescription = null,
        )
      }

      Card(
        modifier = Modifier
          .align(Alignment.Bottom)
          .wrapContentHeight()
          .weight(2f)
          .fillMaxWidth(),
        shape = RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp),
        backgroundColor = MoviesArchTheme.colors.primaryBackground,
        elevation = 8.dp
      ) {
        Column(
          modifier = Modifier
            .padding(16.dp)
        ) {
          Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
              modifier = Modifier.fillMaxWidth().weight(5f),
              text = movie.title,
              style = MoviesArchTheme.typography.title1,
              textAlign = TextAlign.Start,
              maxLines = 1,
              overflow = TextOverflow.Ellipsis,
              color = MoviesArchTheme.colors.primaryText
            )
            if (movie.adult){
              Text(
                modifier = Modifier.fillMaxWidth().weight(1f),
                text = "18+",
                style = MoviesArchTheme.typography.title1,
                textAlign = TextAlign.End,
                maxLines = 1,
                color = MoviesArchTheme.colors.primaryText
              )
            }

          }

          Spacer(modifier = Modifier.padding(4.dp))
          Row {
            CustomRatingBar(
              value = movie.rating.div(2),
              modifier = Modifier.height(14.dp),
              config = RatingBarConfig(
                size = 14.dp,
                isIndicator = true,
                activeColor = MoviesArchTheme.colors.accentColor,
                borderColor = MoviesArchTheme.colors.borderColor,
                style = RatingBarStyle.HighLighted,
              ),
              onValueChange = {},
              onRatingChanged = {}
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
              text = "(${movie.voteCount})",
              style = MoviesArchTheme.typography.body,
              color = MoviesArchTheme.colors.primaryText
            )
          }
          Spacer(modifier = Modifier.padding(4.dp))
          movie.releaseDate?.let { date ->
            Row(verticalAlignment = Alignment.CenterVertically) {
              Icon(
                painter = painterResource(id = R.drawable.ic_calendar),
                "Search icon",
                tint = MoviesArchTheme.colors.tagColor,
                modifier = Modifier.size(16.dp)
              )
              Spacer(modifier = Modifier.padding(4.dp))
              Text(
                text = date,
                style = MoviesArchTheme.typography.body,
                color = MoviesArchTheme.colors.primaryText
              )
            }
          }
          Spacer(modifier = Modifier.padding(4.dp))
          TagsComponent(
            genres = movie.genres,
            limit = 5,
            modifier = Modifier
              .fillMaxWidth()
              .wrapContentHeight()
          )
        }
      }
    }
  }
}


@Composable
@Preview
fun MovieCardPreviewDark() {
  MoviesArchTheme(darkTheme = true) {
    MovieCard(PreviewProvider.movie)
  }
}

@Composable
@Preview
fun MovieCardPreviewWhite() {
  MoviesArchTheme(darkTheme = false) {
    MovieCard(PreviewProvider.movie)
  }
}