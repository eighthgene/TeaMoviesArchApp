package com.oleg.sokolov.search.di

import com.oleg.sokolov.search.data.SearchMoviesRepository
import com.oleg.sokolov.search.data.api.SearchApi
import com.oleg.sokolov.search.domain.SearchFeature
import com.oleg.sokolov.search.ui.viewmodel.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val searchModule = module {

  viewModel {
    SearchViewModel(
      dependencies = SearchFeature.Dependencies(
        searchMoviesRepository = get(),
        genreRepository = get()
      )
    )
  }

  single { provideSearchApi(retrofit = get()) }

  single { SearchMoviesRepository(searchApi = get(), config = get()) }

}

internal fun provideSearchApi(retrofit: Retrofit) = retrofit.create(SearchApi::class.java)