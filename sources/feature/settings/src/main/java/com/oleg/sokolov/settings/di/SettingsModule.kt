package com.oleg.sokolov.settings.di

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import com.oleg.sokolov.api.settings.data.PreferencesRepository
import com.oleg.sokolov.settings.data.PreferencesRepositoryImpl
import com.oleg.sokolov.settings.domain.SettingsFeature
import com.oleg.sokolov.settings.ui.SettingsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private const val THEME_PREFERENCES = "theme_preferences"
private val Context.themeDataStore by preferencesDataStore(THEME_PREFERENCES)

val settingsModule = module {
  viewModel {
    SettingsViewModel(dependencies = get() )
  }

  single { SettingsFeature.Dependencies(themeRepository = get()) }

  single<PreferencesRepository> {
    PreferencesRepositoryImpl(themeDataStore = androidContext().themeDataStore)
  }
}