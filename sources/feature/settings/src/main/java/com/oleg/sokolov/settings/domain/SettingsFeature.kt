package com.oleg.sokolov.settings.domain

import com.oleg.sokolov.api.settings.data.PreferencesRepository
import com.oleg.sokolov.api.settings.model.ThemePreferences
import com.oleg.sokolov.core.data.getOrDefault
import com.oleg.sokolov.tea.Command
import com.oleg.sokolov.tea.Update
import com.oleg.sokolov.tea.noCommands
import com.oleg.sokolov.tea.with

object SettingsFeature {

  data class State(
    val isLoading: Boolean,
    val isDarkMode: Boolean
  )

  sealed class Message {
    data class OnDarkModeSwitched(val isEnabled: Boolean) : Message()
    data class ThemePreferencesLoaded(val themePreferences: ThemePreferences) : Message()
  }

  object Logic {
    private val initialState = State(
      isDarkMode = false,
      isLoading = true
    )
    val initialUpdate = initialState with Commands.ReadThemePreferences

    fun update(message: Message, state: State): Update<State, Message, Dependencies> =
      when (message) {
        is Message.OnDarkModeSwitched -> handleDarkMode(message.isEnabled, state)
        is Message.ThemePreferencesLoaded -> handleLoadedPreferences(state, message.themePreferences)
      }

    private fun handleLoadedPreferences(state: State, themePreferences: ThemePreferences): Update<State, Message, Dependencies> {
      return state.copy(isLoading = false, isDarkMode = themePreferences.isDarkTheme) with noCommands()
    }

    private fun handleDarkMode(
      isEnabled: Boolean,
      state: State
    ): Update<State, Message, Dependencies> {
      return state.copy(isDarkMode = isEnabled) with Commands.SaveThemePreferences(
        ThemePreferences(
          isEnabled
        )
      )
    }
  }

  object Commands {

    class SaveThemePreferences(themePreferences: ThemePreferences) : Command<Dependencies, Message> by Command.idle({ deps ->
      deps.themeRepository.updateThemePreferences(themePreferences)
    })

    object ReadThemePreferences : Command<Dependencies, Message> by Command.single({ deps ->
      val themePreferences = deps.themeRepository.readThemePreferences()
      return@single Message.ThemePreferencesLoaded(
        themePreferences.getOrDefault(
          ThemePreferences(true)
        )
      )
    })
  }

  class Dependencies(
    val themeRepository: PreferencesRepository
  )

}