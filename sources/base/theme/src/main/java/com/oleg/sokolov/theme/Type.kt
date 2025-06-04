package com.oleg.sokolov.theme


import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

val Montserrat = FontFamily(
  Font(R.font.montserrat_light, FontWeight.Light),
  Font(R.font.montserrat_bold, FontWeight.Bold),
  Font(R.font.montserrat_regular, FontWeight.Normal),
  Font(R.font.montserrat_medium, FontWeight.Medium),
  Font(R.font.montserrat_semi_bold, FontWeight.SemiBold),
  )

// Set of Material typography styles to start with
val typography = MoviesArchTypography(

  toolbar = TextStyle(
    fontFamily = Montserrat,
    fontWeight = FontWeight.Bold,
    fontSize = 24.sp,
  ),
  default = TextStyle(
    fontFamily = Montserrat,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
  ),
  title = TextStyle(
    fontFamily = Montserrat,
    fontWeight = FontWeight.Bold,
    fontSize = 32.sp,
  ),
  title1 = TextStyle(
    fontFamily = Montserrat,
    fontWeight = FontWeight.Medium,
    fontSize = 16.sp,
    letterSpacing = (-0.02).em
  ),
  subtitle = TextStyle(
    fontFamily = Montserrat,
    fontWeight = FontWeight.Bold,
    fontSize = 24.sp,
  ),
  subtitle1 = TextStyle(
    fontFamily = Montserrat,
    fontWeight = FontWeight.Normal,
    fontSize = 20.sp,
  ),
  subtitle2 = TextStyle(
    fontFamily = Montserrat,
    fontWeight = FontWeight.Normal,
    fontSize = 18.sp,
  ),
  body = TextStyle(
    fontFamily = Montserrat,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp,
  ),
  body1 = TextStyle(
    fontFamily = Montserrat,
    fontWeight = FontWeight.Normal,
    fontSize = 10.sp,
  ),
  tag = TextStyle(
    fontFamily = Montserrat,
    fontWeight = FontWeight.Normal,
    fontSize = 10.sp,
  )

)