package com.oleg.sokolov.theme

import androidx.compose.runtime.MutableState

interface ThemedApplication {

    val appThemeState: MutableState<AppThemeState>

    fun setDarkTheme(isDark: Boolean)
}