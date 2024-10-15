package com.cinetalks.movie_review_service.domain.repository

import com.cinetalks.movie_review_service.domain.entity.Movie
import com.cinetalks.movie_review_service.domain.entity.Review
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ReviewRepository : JpaRepository<Review, Long> {

    fun findAllByIsActive(isActive: Boolean): List<Review>

    fun findByMemberIdAndMovieId(userId: Long, movieId: Long): Optional<Review>


}