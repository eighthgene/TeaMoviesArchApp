package com.oleg.sokolov.genre.di

import com.oleg.sokolov.api.genre.data.GenreRepository
import com.oleg.sokolov.api.genre.model.Genre
import com.oleg.sokolov.core.data.ListCache
import com.oleg.sokolov.genre.data.api.GenreApi
import com.oleg.sokolov.genre.data.repositories.GenreRepositoryImpl
import org.koin.dsl.module
import retrofit2.Retrofit

val genreModule = module {

  single<GenreRepository> { GenreRepositoryImpl(cache = get(), genreApi = provideGenreApi(retrofit = get()), config = get())  }

  single { ListCache<Genre>() }
}

internal fun provideGenreApi(retrofit: Retrofit) = retrofit.create(GenreApi::class.java)