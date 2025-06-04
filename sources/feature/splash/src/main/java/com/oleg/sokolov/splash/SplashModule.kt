package com.oleg.sokolov.splash

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val splashModule = module {

  viewModel {
    SplashViewModel(
      SplashFeature.Dependencies(
        themeRepository = get(),
        router = get()
      )
    )
  }


}