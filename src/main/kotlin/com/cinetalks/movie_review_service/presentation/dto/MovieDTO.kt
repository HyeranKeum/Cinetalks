package com.cinetalks.movie_review_service.presentation.dto

import com.cinetalks.movie_review_service.domain.entity.Movie
import java.time.format.DateTimeFormatter


class MovieDTO(
    val title: String,
    val releasedDate: String,
    val director: String,
    val duration: String,
    val description: String,
    val genres: List<GenreDTO>,
    val reviews: List<ReviewDTO>
    ) {
    constructor(movie: Movie) : this(
        title = movie.title,
        releasedDate = movie.releasedDate.format(DateTimeFormatter.ISO_LOCAL_DATE), // releasedDate를 String으로 변환
        director = movie.director,
        duration = "${movie.duration}",
        description = movie.description,
        genres = movie.genres.map{ GenreDTO(it.genre)},
        reviews = movie.reviews.filter{ it.isActive }.map { ReviewDTO(it) }
    )

}