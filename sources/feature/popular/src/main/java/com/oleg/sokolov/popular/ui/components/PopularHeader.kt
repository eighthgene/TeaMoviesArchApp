package com.oleg.sokolov.popular.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.oleg.sokolov.theme.MoviesArchTheme

@Composable
fun PopularHeader() {

  Spacer(modifier = Modifier.height(30.dp))

  Text(
    modifier = Modifier.padding(16.dp),
    text = "Popular movies",
    color = MoviesArchTheme.colors.primaryText,
    style = MaterialTheme.typography.h4.copy(fontWeight = FontWeight.ExtraBold)
  )

}