package com.oleg.sokolov.api.settings.di

import com.oleg.sokolov.api.settings.SettingsFeatureApi
import com.oleg.sokolov.api.settings.data.PreferencesRepository
import org.koin.dsl.module

val settingsApi = module {
    factory<SettingsFeatureApi>{
        object : SettingsFeatureApi {
            override fun settingsPreferencesRepository(): PreferencesRepository = get()
        }
    }
}