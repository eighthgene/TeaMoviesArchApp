package com.oleg.sokolov.movies.arch.di


import com.oleg.sokolov.api.genre.di.genreApi
import com.oleg.sokolov.api.settings.di.settingsApi
import com.oleg.sokolov.genre.di.genreModule
import com.oleg.sokolov.network.di.networkModule
import com.oleg.sokolov.popular.di.popularModule
import com.oleg.sokolov.search.di.searchModule
import com.oleg.sokolov.settings.di.settingsModule
import com.oleg.sokolov.splash.splashModule

val apiModules = listOf(
  settingsApi,
  genreApi
)

val featureModules = listOf(
  networkModule,
  splashModule,
  searchModule,
  popularModule,
  genreModule,
  settingsModule,
)

val koinModules =
  appModule +
  apiModules +
  featureModules





