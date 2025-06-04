package com.oleg.sokolov.popular.ui.viewmodel

import com.oleg.sokolov.popular.domain.PopularFeature
import com.oleg.sokolov.tea.android.TeaViewModel

class PopularViewModel(
  dependencies: PopularFeature.Dependencies
) : TeaViewModel<PopularFeature.State, PopularFeature.Message, PopularFeature.Dependencies>(
  init = PopularFeature.Logic.initialUpdate,
  update = PopularFeature.Logic::update,
  dependencies = dependencies
)