package com.oleg.sokolov.movies.arch.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.oleg.sokolov.common.core.navigation.Router
import com.oleg.sokolov.common.extentions.asLifecycleAwareState
import com.oleg.sokolov.common.navigation.NavigationDestinations

import org.koin.androidx.compose.get

@ExperimentalPagerApi
@ExperimentalFoundationApi
@Composable
fun MainNavHost(
  navController: NavHostController = rememberNavController(),
  router: Router = get()
){
  val lifecycleOwner = LocalLifecycleOwner.current

  val navigatorState by router.navActions.asLifecycleAwareState(
    lifecycleOwner = lifecycleOwner,
    initialState = null
  )

  LaunchedEffect(navigatorState) {
    navigatorState?.let {
      it.parcelableArguments.forEach { arg ->
        navController.currentBackStackEntry?.arguments?.putParcelable(arg.key, arg.value)
      }
      navController.navigate(it.destination, it.navOptions)
    }
  }

  NavHost(
    navController = navController,
    startDestination = NavigationDestinations.SPLASH_SCREEN
  ) {
    setupMainFlow()
  }

}

