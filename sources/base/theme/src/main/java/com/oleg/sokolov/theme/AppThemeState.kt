package com.oleg.sokolov.theme

data class AppThemeState(
  val darkMode: Boolean = true,
  val paddingSize : MoviesArchSize = MoviesArchSize.Big,
  val fontSize: MoviesArchSize = MoviesArchSize.Medium,
  val corners: MoviesArchCorners = MoviesArchCorners.Rounded
)