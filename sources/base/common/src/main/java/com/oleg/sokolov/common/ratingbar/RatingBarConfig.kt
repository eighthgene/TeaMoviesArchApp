package com.oleg.sokolov.common.ratingbar

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class RatingBarConfig(
  val size: Dp = 50.dp,
  val padding: Dp = 1.dp,
  val style: RatingBarStyle = RatingBarStyle.Normal,
  val numStars: Int = 5,
  val isIndicator: Boolean = false,
  val activeColor: Color = Color.Red,
  val inactiveColor: Color = Color.Red.copy(alpha = 0.5f),
  val borderColor: Color = Color.Gray,
  val stepSize: StepSize = StepSize.ONE,
  val hideInactiveStars: Boolean = false,
)















