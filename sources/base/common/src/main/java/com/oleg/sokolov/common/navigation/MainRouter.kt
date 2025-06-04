package com.oleg.sokolov.common.navigation

import com.oleg.sokolov.common.core.navigation.NavigationAction
import com.oleg.sokolov.common.core.navigation.Router
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainRouter : Router {

  private val _navActions: MutableStateFlow<NavigationAction?> by lazy {
    MutableStateFlow(null)
  }

  override val navActions = _navActions.asStateFlow()

  override fun navigate(navAction: NavigationAction?) {
    _navActions.update { navAction }
  }

}