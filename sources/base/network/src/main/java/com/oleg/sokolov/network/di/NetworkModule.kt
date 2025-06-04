package com.oleg.sokolov.network.di;

import com.oleg.sokolov.network.model.ServiceConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL = "https://api.themoviedb.org/3/"
const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w300"
const val API_KEY = "b079ddd2b0ef3f93ea74060bd44a8c44"

val networkModule = module {

  single {
    ServiceConfig(
      baseUrl = BASE_URL,
      baseImageUrl = BASE_IMAGE_URL,
      apiKey = API_KEY
    )
  }

  single {
    HttpLoggingInterceptor().apply {
      level = HttpLoggingInterceptor.Level.BODY
    }
  }

  single {
    OkHttpClient.Builder()
      .addInterceptor(get<HttpLoggingInterceptor>())
      .connectTimeout(30, TimeUnit.SECONDS)
      .writeTimeout(30, TimeUnit.SECONDS)
      .readTimeout(30, TimeUnit.SECONDS)
      .build()
  }

  single<Retrofit> {
    Retrofit.Builder()
      .baseUrl(BASE_URL)
      .client(get())
      .addConverterFactory(GsonConverterFactory.create())
      .build()
  }

}