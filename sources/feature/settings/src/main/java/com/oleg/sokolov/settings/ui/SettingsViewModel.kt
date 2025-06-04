package com.oleg.sokolov.settings.ui

import com.oleg.sokolov.settings.domain.SettingsFeature
import com.oleg.sokolov.tea.android.TeaViewModel

class SettingsViewModel(
  val dependencies: SettingsFeature.Dependencies
) : TeaViewModel<SettingsFeature.State, SettingsFeature.Message, SettingsFeature.Dependencies>(
  init = SettingsFeature.Logic.initialUpdate,
  update = SettingsFeature.Logic::update,
  dependencies = dependencies
) {

}