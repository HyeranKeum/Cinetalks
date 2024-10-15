package com.cinetalks.movie_review_service.domain.repository

import com.cinetalks.movie_review_service.domain.constant.Genre
import com.cinetalks.movie_review_service.domain.entity.Movie
import com.cinetalks.movie_review_service.domain.entity.MovieGenre
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface MovieGenreRepository : JpaRepository<MovieGenre, Long> {

    fun findByMovieIdAndGenre(movieId: Long, genre: Genre): Optional<MovieGenre>

 //   fun findByGenre(genre: Genre): List<MovieGenre>
}