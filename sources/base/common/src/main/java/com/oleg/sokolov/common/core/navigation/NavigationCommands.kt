package com.oleg.sokolov.common.core.navigation

import com.oleg.sokolov.tea.Command

object NavigationCommands {

  class Forward(navigationAction: NavigationAction) : Command<Router, Unit> by Command.onMain.idle({ navigator ->
    navigator.navigate(navigationAction)
  })

}