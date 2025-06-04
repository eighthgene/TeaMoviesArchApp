package com.oleg.sokolov.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.oleg.sokolov.theme.MoviesArchTheme

@Composable
fun SplashView() {
  val rotation = remember { Animatable(0f) }
  LaunchedEffect(key1 = true) {
    rotation.animateTo(
      targetValue = 360f,
      animationSpec = tween(10000, easing = { OvershootInterpolator(2f).getInterpolation(it) })
    )
  }

  Box(
    modifier = Modifier.fillMaxSize().background(MoviesArchTheme.colors.primaryBackground),
    contentAlignment = Alignment.Center
  ) {
    Image(
      painter = painterResource(id = R.drawable.ic_movies_reel),
      contentDescription = "Logo",
      modifier = Modifier.rotate(rotation.value)
    )
  }
}

@Preview
@Composable
fun PreviewSplashView(){
  MoviesArchTheme(darkTheme = true){
    SplashView()
  }
}