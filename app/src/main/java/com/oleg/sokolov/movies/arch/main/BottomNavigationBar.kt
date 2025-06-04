package com.oleg.sokolov.movies.arch.main

import androidx.compose.foundation.background
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.oleg.sokolov.movies.arch.navigation.MainBottomScreen
import com.oleg.sokolov.theme.MoviesArchTheme

@Composable
fun BottomNavBar(bottomNavController: NavHostController) {
  BottomNavigation(
    backgroundColor = MoviesArchTheme.colors.primaryBackground) {
    val navBackStackEntry by bottomNavController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    // Bottom navigation items
    val items = listOf(
      MainBottomScreen.Search,
      MainBottomScreen.Popular,
      MainBottomScreen.Settings,
    )

    items.forEach { screen ->
      val isSelected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
      BottomNavigationItem(
        modifier = Modifier.background(MoviesArchTheme.colors.primaryBackground),
        icon = {
          Icon(
            imageVector = when (screen) {
              MainBottomScreen.Search -> Icons.Filled.Search
              MainBottomScreen.Popular -> Icons.Filled.Favorite
              MainBottomScreen.Settings -> Icons.Filled.Settings
            },
            contentDescription = stringResource(screen.resourceId),
            tint = if (isSelected) MoviesArchTheme.colors.accentColor else MoviesArchTheme.colors.controlColor
          )
        },
        label = {
          Text(
            stringResource(id = screen.resourceId),
            color = if (isSelected) MoviesArchTheme.colors.primaryText else MoviesArchTheme.colors.controlColor
          )
        },
        selected = isSelected,
        onClick = {
          bottomNavController.navigate(screen.route) {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(bottomNavController.graph.findStartDestination().id) {
              saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
          }
        })
    }
  }
}