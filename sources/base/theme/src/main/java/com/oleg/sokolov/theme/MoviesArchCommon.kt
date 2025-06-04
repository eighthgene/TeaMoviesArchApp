package com.oleg.sokolov.theme


import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp


data class MoviesArchColors(
  val primaryText: Color,
  val primaryTextHint: Color,
  val primaryBackground: Color,
  val accentColor: Color,
  val borderColor: Color,
  val secondaryText: Color,
  val secondaryBackground: Color,
  val reverseBackground: Color,
  val controlColor: Color,
  val tagColor: Color,
  val errorColor: Color,
  val whiteColor: Color,
  val darkColor: Color,
  )

data class MoviesArchTypography(
  val toolbar: TextStyle,
  val default: TextStyle,
  val title: TextStyle,
  val title1: TextStyle,
  val subtitle: TextStyle,
  val subtitle1: TextStyle,
  val subtitle2: TextStyle,
  val body: TextStyle,
  val body1: TextStyle,
  val tag: TextStyle,
)

data class MoviesArchShape(
  val padding: Dp,
  val cornersStyle: Shape
)

enum class MoviesArchSize {
  Small, Medium, Big
}

enum class MoviesArchCorners {
  Flat, Rounded
}

object MoviesArchTheme {
  val colors: MoviesArchColors
    @Composable
    get() = LocalMoviesArchColors.current

  val typography: MoviesArchTypography
    @Composable
    get() = LocalMoviesArchTypography.current

  val shape: MoviesArchShape
    @Composable
    get() = LocalMoviesArchShape.current
}


val LocalMoviesArchColors = staticCompositionLocalOf<MoviesArchColors> {
  error("No colors provided")
}

val LocalMoviesArchTypography = staticCompositionLocalOf<MoviesArchTypography> {
  error("No typography provided")
}

val LocalMoviesArchShape = staticCompositionLocalOf<MoviesArchShape> {
  error("No shape provided")
}