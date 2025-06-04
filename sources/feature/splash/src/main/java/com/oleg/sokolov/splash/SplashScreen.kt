package com.oleg.sokolov.splash


import androidx.compose.runtime.Composable
import com.oleg.sokolov.theme.ThemedApplication
import org.koin.androidx.compose.get


@Composable
fun SplashScreen(
  state: SplashFeature.State,
  moviesArchApp: ThemedApplication = get()
) {
  SplashView()

  state.themePreferences?.let {
    moviesArchApp.setDarkTheme(state.themePreferences.isDarkTheme)
  }

}