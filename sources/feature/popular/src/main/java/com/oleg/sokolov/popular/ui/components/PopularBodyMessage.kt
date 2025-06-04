package com.oleg.sokolov.popular.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import com.oleg.sokolov.common.models.common.ui.Text
import com.oleg.sokolov.theme.MoviesArchTheme

@Composable
fun PopularBodyMessage(message: Text){
  Column(modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ){
    Text(
      color = MoviesArchTheme.colors.primaryText,
      textAlign = TextAlign.Center,
      text = message.resolve(context = LocalContext.current).toString()
    )
  }
}