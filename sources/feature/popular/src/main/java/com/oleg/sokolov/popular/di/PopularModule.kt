package com.oleg.sokolov.popular.di

import com.oleg.sokolov.popular.data.api.PopularApi
import com.oleg.sokolov.popular.data.repositories.PopularMoviesRepository
import com.oleg.sokolov.popular.domain.PopularFeature
import com.oleg.sokolov.popular.ui.viewmodel.PopularViewModel

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val popularModule = module {

  viewModel { PopularViewModel(dependencies = get()) }

  single { PopularFeature.Dependencies(repository = get()) }

  single { PopularMoviesRepository(popularApi = get(), config = get()) }

  factory { providePopularApi(retrofit = get()) }

}


internal fun providePopularApi(retrofit: Retrofit) = retrofit.create(PopularApi::class.java)