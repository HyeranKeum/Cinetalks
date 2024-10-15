package com.cinetalks.movie_review_service.presentation.dto

import com.cinetalks.movie_review_service.domain.constant.Genre

class GenreDTO(
    val genre: String,
) {
    constructor(genre: Genre) : this(
        genre = genre.name
    )
}