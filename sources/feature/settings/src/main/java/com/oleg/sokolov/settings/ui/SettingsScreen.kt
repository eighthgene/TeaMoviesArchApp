package com.oleg.sokolov.settings.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.oleg.sokolov.settings.domain.SettingsFeature
import com.oleg.sokolov.tea.android.TeaViewModel
import com.oleg.sokolov.theme.ThemedApplication
import org.koin.androidx.compose.inject

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    viewModel: TeaViewModel<SettingsFeature.State, SettingsFeature.Message, SettingsFeature.Dependencies>,
    state: SettingsFeature.State,
) {

  val app: ThemedApplication by inject()

  when (state.isLoading) {
    true -> {
      Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
      ) {
        CircularProgressIndicator()
      }
    }

    false -> SettingsView(
      isDarkChecked = state.isDarkMode
    ) {
      viewModel.dispatch(SettingsFeature.Message.OnDarkModeSwitched(it))
      //app.appThemeState.value = app.appThemeState.value.copy(darkMode = it)
      app.setDarkTheme(it)
      //onSettingsChanged(AppThemeState(darkMode = it))
    }
  }


}