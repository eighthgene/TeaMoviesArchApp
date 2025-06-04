package com.oleg.sokolov.api.genre.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.oleg.sokolov.theme.MoviesArchTheme
import com.oleg.sokolov.theme.bold

@Composable
fun GenreTag(
  text: String,
  modifier: Modifier = Modifier
) {
  Surface(
    color = Color.Transparent,
    contentColor = MoviesArchTheme.colors.tagColor,
    shape = CircleShape,
    border = BorderStroke(
      width = 0.5.dp,
      color = MoviesArchTheme.colors.borderColor
    ),
    modifier = modifier
  ) {
    Text(
      text = text,
      textAlign = TextAlign.Center,
      style = MoviesArchTheme.typography.tag.bold,
      overflow = TextOverflow.Ellipsis,
      color = MoviesArchTheme.colors.tagColor,
      modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    )
  }
}