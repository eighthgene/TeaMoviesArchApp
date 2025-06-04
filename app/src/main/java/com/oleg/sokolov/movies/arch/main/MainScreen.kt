package com.oleg.sokolov.movies.arch.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.oleg.sokolov.movies.arch.navigation.MainBottomScreen
import com.oleg.sokolov.movies.arch.navigation.setupBottomBarFlow
import com.oleg.sokolov.theme.MoviesArchTheme


@ExperimentalPagerApi
@ExperimentalFoundationApi
@Composable
fun MainScreen() {

  val bottomNavController = rememberNavController()

  Surface {
    Column(modifier = Modifier
      .background(MoviesArchTheme.colors.primaryBackground)
    ) {
      Box(modifier = Modifier.weight(1f)
      ) {
        NavHost(
          navController = bottomNavController,
          startDestination = MainBottomScreen.Search.route
        ) {
          setupBottomBarFlow()
        }
      }
      Box(modifier = Modifier
        .height(56.dp)
        .fillMaxWidth()
      ) {
        BottomNavBar(bottomNavController)
      }
    }
  }
}