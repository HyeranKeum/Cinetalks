package com.cinetalks.movie_review_service.domain.repository

import com.cinetalks.movie_review_service.domain.constant.Genre
import com.cinetalks.movie_review_service.domain.entity.Movie
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface MovieRepository : JpaRepository<Movie, Long> {

    fun findAllByIsActive(isActive: Boolean): List<Movie>



    override fun findById(id: Long): Optional<Movie>

}