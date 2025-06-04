package com.oleg.sokolov.popular.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.oleg.sokolov.theme.MoviesArchTheme

@Composable
fun PopularLoading() {
  Box(
    modifier = Modifier.fillMaxSize()
  ) {
    CircularProgressIndicator(
      modifier = Modifier.align(Alignment.Center),
      color = MoviesArchTheme.colors.accentColor
    )
  }
}