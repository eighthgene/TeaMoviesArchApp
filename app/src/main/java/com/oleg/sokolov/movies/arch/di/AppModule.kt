package com.oleg.sokolov.movies.arch.di


import com.oleg.sokolov.common.core.navigation.Router
import com.oleg.sokolov.common.navigation.MainRouter
import com.oleg.sokolov.theme.ThemedApplication
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val appModule = module {

  single<Router> { MainRouter() }

  single { androidApplication() as ThemedApplication }

}