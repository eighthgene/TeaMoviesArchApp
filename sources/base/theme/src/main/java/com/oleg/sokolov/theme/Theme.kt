package com.oleg.sokolov.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.dp

@Composable
fun MoviesArchTheme(
  textSize: MoviesArchSize = MoviesArchSize.Medium,
  paddingSize: MoviesArchSize = MoviesArchSize.Medium,
  corners: MoviesArchCorners = MoviesArchCorners.Rounded,
  darkTheme: Boolean = isSystemInDarkTheme(),
  content: @Composable () -> Unit
) {

  val colors = if (darkTheme) {
    BaseDarkPalette
  } else {
    BaseLightPalette
  }

  val shapes = MoviesArchShape(
    padding = when (paddingSize) {
      MoviesArchSize.Small -> 12.dp
      MoviesArchSize.Medium -> 16.dp
      MoviesArchSize.Big -> 20.dp
    },
    cornersStyle = when (corners) {
      MoviesArchCorners.Flat -> RoundedCornerShape(0.dp)
      MoviesArchCorners.Rounded -> RoundedCornerShape(8.dp)
    }
  )

  CompositionLocalProvider(
    LocalMoviesArchColors provides colors,
    LocalMoviesArchTypography provides typography,
    LocalMoviesArchShape provides shapes,
    content = content
  )

}