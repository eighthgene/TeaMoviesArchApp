package com.oleg.sokolov.search.ui.viewmodel

import com.oleg.sokolov.search.domain.SearchFeature
import com.oleg.sokolov.tea.android.TeaViewModel

class SearchViewModel(
  dependencies: SearchFeature.Dependencies
): TeaViewModel<SearchFeature.State, SearchFeature.Message, SearchFeature.Dependencies>(
  init = SearchFeature.Logic.initialUpdate,
  update = SearchFeature.Logic::update,
  dependencies = dependencies
)