package com.oleg.sokolov.api.settings.data

import com.oleg.sokolov.api.settings.model.ThemePreferences
import com.oleg.sokolov.core.data.Try

interface PreferencesRepository {

    suspend fun readThemePreferences(): Try<ThemePreferences>

    suspend fun updateThemePreferences(themePreferences: ThemePreferences)

}