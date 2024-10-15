package com.cinetalks.movie_review_service.domain.repository

import com.cinetalks.movie_review_service.domain.constant.Genre
import com.cinetalks.movie_review_service.domain.entity.Movie
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.*

interface MovieRepository : JpaRepository<Movie, Long> {

    fun findAllByIsActive(isActive: Boolean): List<Movie>

    @Query("SELECT m FROM Movie m JOIN m.genres mg WHERE mg.genre = :genre")
    fun findByGenreId(@Param("genre") genre: Genre): List<Movie>

    override fun findById(id: Long): Optional<Movie>

}