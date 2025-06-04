package com.oleg.sokolov.search.ui.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.oleg.sokolov.theme.MoviesArchTheme

@Composable
fun SearchLoadingView() {
  Box(
    modifier = Modifier.fillMaxSize()
  ) {
    CircularProgressIndicator(
      modifier = Modifier.align(Alignment.Center),
      color = MoviesArchTheme.colors.accentColor
    )
  }
}

@Preview
@Composable
fun DailyViewLoading_Preview() {
  MoviesArchTheme(darkTheme = true) {
    SearchLoadingView()
  }
}