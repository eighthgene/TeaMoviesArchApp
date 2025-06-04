package com.oleg.sokolov.common.navigation

import android.annotation.SuppressLint
import androidx.navigation.NavOptions
import com.oleg.sokolov.common.core.navigation.NavigationAction

object NavigationDestinations {
  const val SPLASH_SCREEN = "splash_screen"
  const val MAIN_SCREEN = "main_screen"
}


object NavigationActions {

  @SuppressLint("CustomSplashScreen")
  object SplashScreen {

    fun navigateToMainScreen() = object : NavigationAction {

      override val destination: String
        get() = NavigationDestinations.MAIN_SCREEN

      override val navOptions: NavOptions
        get() = NavOptions.Builder()
          .setPopUpTo(route = NavigationDestinations.SPLASH_SCREEN, inclusive = true)
          .build()
    }
  }

}