package com.oleg.sokolov.api.settings

import com.oleg.sokolov.api.settings.data.PreferencesRepository

interface SettingsFeatureApi {

    fun settingsPreferencesRepository() : PreferencesRepository

}