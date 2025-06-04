package com.oleg.sokolov.settings.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oleg.sokolov.settings.R
import com.oleg.sokolov.theme.MoviesArchTheme

@Composable
fun SettingsToggleView(
  isEnabled: Boolean,
  onChecked: (Boolean) -> Unit
) {
  Card(
    backgroundColor = MoviesArchTheme.colors.secondaryBackground,
    elevation = 8.dp,
    modifier = Modifier.padding(16.dp)
  ) {
    Row(
      modifier = Modifier.padding(8.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(
        modifier = Modifier.weight(1f).padding(start = 8.dp),
        text = stringResource(id = R.string.settings_dark_mode_toggle),
        color = MoviesArchTheme.colors.primaryText,
      )
      Checkbox(
        checked = isEnabled,
        onCheckedChange = { onChecked(it) },
        colors = CheckboxDefaults.colors(
          checkedColor = MoviesArchTheme.colors.accentColor,
          uncheckedColor = MoviesArchTheme.colors.secondaryText
        )
      )
    }
  }
}

@Composable
@Preview
fun SettingsTogglePreview() {
  MoviesArchTheme(darkTheme = false) {
    SettingsToggleView(
      isEnabled = true,
      onChecked = {}
    )
  }
}