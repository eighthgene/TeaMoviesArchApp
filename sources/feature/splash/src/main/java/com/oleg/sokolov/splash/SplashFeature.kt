package com.oleg.sokolov.splash

import com.oleg.sokolov.api.settings.data.PreferencesRepository
import com.oleg.sokolov.api.settings.model.ThemePreferences
import com.oleg.sokolov.common.core.navigation.NavigationCommands
import com.oleg.sokolov.common.core.navigation.Router
import com.oleg.sokolov.common.navigation.NavigationActions
import com.oleg.sokolov.core.data.getOrDefault
import com.oleg.sokolov.tea.Command
import com.oleg.sokolov.tea.Update
import com.oleg.sokolov.tea.adaptIdle
import com.oleg.sokolov.tea.with

object SplashFeature {

  data class State(
    val isLoading: Boolean = true,
    val themePreferences: ThemePreferences? = null
  )

  sealed class Message {

    // System
    data class SettingsLoaded(val themePreferences: ThemePreferences) : Message()
  }

  object Logic {
    val initialUpdate = State() with Commands.GetSettings

    fun update(message: Message, state: State): Update<State, Message, Dependencies> =
      when (message) {
        is Message.SettingsLoaded -> handleSettingsLoaded(state = state, themePreferences = message.themePreferences)
      }

    private fun handleSettingsLoaded(state: State, themePreferences: ThemePreferences) : Update<State, Message, Dependencies> =
      state.copy(themePreferences = themePreferences) with NavigationCommands.Forward(
        NavigationActions.SplashScreen.navigateToMainScreen())
        .adaptIdle { deps -> deps.router }
  }

  object Commands {
    object GetSettings : Command<Dependencies, Message> by Command.single({ deps ->
      val themePreferences = deps.themeRepository.readThemePreferences()
      return@single Message.SettingsLoaded(themePreferences.getOrDefault(ThemePreferences(true)))
    })
  }

  class Dependencies(
    val themeRepository: PreferencesRepository,
    val router: Router
  )
}