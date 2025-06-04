package com.oleg.sokolov.settings.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.oleg.sokolov.api.settings.data.PreferencesRepository
import com.oleg.sokolov.api.settings.model.ThemePreferences
import com.oleg.sokolov.core.data.Try
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map


class PreferencesRepositoryImpl(
  private val themeDataStore: DataStore<Preferences>
) : PreferencesRepository {

  private object PreferencesKeys {
    val DARK_THEME = booleanPreferencesKey("dark_theme")
  }

  override suspend fun readThemePreferences(): Try<ThemePreferences> {
    return try {
      themeDataStore.data
        .map { preferences -> mapToThemePreferences(preferences) }
        .first()
    } catch (e: Exception) {
      Try.Failure(e)
    }
  }

  override suspend fun updateThemePreferences(themePreferences: ThemePreferences) {
    themeDataStore.edit { preferences ->
      preferences[PreferencesKeys.DARK_THEME] = themePreferences.isDarkTheme
    }

  }

  private fun mapToThemePreferences(preferences: Preferences) =
    Try.Success(
      ThemePreferences(preferences[PreferencesKeys.DARK_THEME] ?: true)
    )

}