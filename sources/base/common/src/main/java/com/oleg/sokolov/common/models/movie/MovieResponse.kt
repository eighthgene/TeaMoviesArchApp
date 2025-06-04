package com.oleg.sokolov.common.models.movie

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val searchMovies: List<MovieEntity>
)
