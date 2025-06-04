package com.oleg.sokolov.movies.arch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.SideEffect
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.oleg.sokolov.movies.arch.navigation.MainNavHost
import com.oleg.sokolov.theme.BaseDarkPalette
import com.oleg.sokolov.theme.BaseLightPalette
import com.oleg.sokolov.theme.MoviesArchTheme
import com.oleg.sokolov.theme.ThemedApplication

import org.koin.android.ext.android.inject

@ExperimentalPagerApi
@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {

  private val app: ThemedApplication by inject()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {

      MoviesArchTheme(
        textSize = app.appThemeState.value.fontSize,
        paddingSize = app.appThemeState.value.paddingSize,
        corners = app.appThemeState.value.corners,
        darkTheme = app.appThemeState.value.darkMode
      ) {

        MainNavHost()

        val systemUiController = rememberSystemUiController()
        // Set status bar color
        SideEffect {
          systemUiController.setSystemBarsColor(
            color = if (app.appThemeState.value.darkMode) BaseDarkPalette.primaryBackground else BaseLightPalette.primaryBackground,
            darkIcons = !app.appThemeState.value.darkMode
          )
        }
      }
    }
  }
}

