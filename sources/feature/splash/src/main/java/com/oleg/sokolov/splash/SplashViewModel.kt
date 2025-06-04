package com.oleg.sokolov.splash

import com.oleg.sokolov.tea.android.TeaViewModel

class SplashViewModel(
  dependencies: SplashFeature.Dependencies
) :
  TeaViewModel<SplashFeature.State, SplashFeature.Message, SplashFeature.Dependencies>(
    init = SplashFeature.Logic.initialUpdate,
    update = SplashFeature.Logic::update,
    dependencies = dependencies
  )