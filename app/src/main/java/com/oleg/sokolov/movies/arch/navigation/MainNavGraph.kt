package com.oleg.sokolov.movies.arch.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.oleg.sokolov.common.navigation.NavigationDestinations
import com.oleg.sokolov.movies.arch.main.MainScreen
import com.oleg.sokolov.splash.SplashScreen
import com.oleg.sokolov.splash.SplashViewModel
import com.oleg.sokolov.tea.android.TeaScreen
import org.koin.androidx.compose.getViewModel

@ExperimentalPagerApi
@ExperimentalFoundationApi
fun NavGraphBuilder.setupMainFlow() {

  // Splash
  composable(NavigationDestinations.SPLASH_SCREEN) {
    TeaScreen(viewModel = getViewModel<SplashViewModel>()) { _, state ->
      SplashScreen(state)
    }
  }

  // Main
  composable(NavigationDestinations.MAIN_SCREEN) {
    MainScreen()
  }
}