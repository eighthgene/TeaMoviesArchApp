package com.oleg.sokolov.movies.arch

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.jakewharton.threetenabp.AndroidThreeTen
import com.oleg.sokolov.movies.arch.di.koinModules
import com.oleg.sokolov.theme.AppThemeState
import com.oleg.sokolov.theme.ThemedApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MoviesArchApp: Application(), ThemedApplication {

  override val appThemeState: MutableState<AppThemeState> = mutableStateOf(AppThemeState())

  override fun setDarkTheme(isDark: Boolean) {
    appThemeState.value = appThemeState.value.copy(darkMode = isDark)
  }

  override fun onCreate() {
    super.onCreate()
    AndroidThreeTen.init(this)

    startKoin {
      androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
      androidContext(this@MoviesArchApp)
      modules(koinModules)
    }
  }
}