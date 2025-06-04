package com.oleg.sokolov.api.genre.di

import com.oleg.sokolov.api.genre.GenreFeatureApi
import com.oleg.sokolov.api.genre.data.GenreRepository
import org.koin.dsl.module

val genreApi = module {
    factory<GenreFeatureApi> {
        object : GenreFeatureApi {
            override fun genreRepository(): GenreRepository = get()
        }
    }
}