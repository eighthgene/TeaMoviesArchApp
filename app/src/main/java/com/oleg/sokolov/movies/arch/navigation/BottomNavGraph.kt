package com.oleg.sokolov.movies.arch.navigation

import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.oleg.sokolov.movies.arch.R
import com.oleg.sokolov.popular.ui.PopularScreen
import com.oleg.sokolov.popular.ui.viewmodel.PopularViewModel
import com.oleg.sokolov.search.ui.SearchScreen
import com.oleg.sokolov.search.ui.viewmodel.SearchViewModel
import com.oleg.sokolov.settings.ui.SettingsScreen
import com.oleg.sokolov.settings.ui.SettingsViewModel
import com.oleg.sokolov.tea.android.TeaScreen
import org.koin.androidx.compose.getViewModel

sealed class MainBottomScreen(val route: String, @StringRes val resourceId: Int) {
  object Search : MainBottomScreen("SearchFlow", R.string.title_bottom_menu_search)
  object Popular : MainBottomScreen("PopularFlow", R.string.title_bottom_menu_popular)
  object Settings : MainBottomScreen("SettingsFlow", R.string.title_bottom_menu_settings)
}

@ExperimentalPagerApi
@ExperimentalFoundationApi
fun NavGraphBuilder.setupBottomBarFlow() {

  // Search screen
  composable(MainBottomScreen.Search.route) {
    TeaScreen(viewModel = getViewModel<SearchViewModel>()) { viewModel, state ->
      SearchScreen(viewModel = viewModel, state = state)
    }
  }

  // Popular screen
  composable(MainBottomScreen.Popular.route) {
    TeaScreen(viewModel = getViewModel<PopularViewModel>()) { viewModel, state ->
        PopularScreen(viewModel = viewModel, state = state)
    }

  }

  // Settings screen
  composable(MainBottomScreen.Settings.route) {
    TeaScreen(viewModel = getViewModel<SettingsViewModel>()) { viewModel, state ->
      SettingsScreen(viewModel = viewModel, state = state)
    }
  }
}