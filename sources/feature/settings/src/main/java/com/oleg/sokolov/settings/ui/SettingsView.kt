package com.oleg.sokolov.settings.ui


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oleg.sokolov.settings.ui.components.SettingsTextItemView
import com.oleg.sokolov.settings.ui.components.SettingsToggleView
import com.oleg.sokolov.theme.MoviesArchTheme

@Composable
fun SettingsView(
    modifier: Modifier = Modifier,
    isDarkChecked: Boolean,
    onChecked: (Boolean) -> Unit,
) {

    val context = LocalContext.current

    Surface(
        modifier = modifier.padding(8.dp),
        color = MoviesArchTheme.colors.primaryBackground
    ) {
        Column(
            Modifier.fillMaxSize()
        ) {
            SettingsToggleView(
                isEnabled = isDarkChecked,
                onChecked = onChecked
            )

            val info = context.packageManager?.getPackageInfo(context.packageName, 0)
            val versionName = info?.versionName
            versionName?.let {
                SettingsTextItemView(
                    title = "Application version: ",
                    value = it
                )
            }
        }
    }
}

@Preview
@Composable
fun SettingsViewPreview() {
    MoviesArchTheme {
        SettingsView(
            isDarkChecked = false,
            onChecked = {},
        )
    }
}