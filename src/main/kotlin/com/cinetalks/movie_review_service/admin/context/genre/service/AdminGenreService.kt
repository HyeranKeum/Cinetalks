package com.cinetalks.movie_review_service.admin.context.genre.service

import com.cinetalks.movie_review_service.admin.context.genre.form.GenreForm
import com.cinetalks.movie_review_service.admin.context.movie.form.MovieForm
import com.cinetalks.movie_review_service.domain.constant.Genre
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminGenreService(
    private val genre: Genre
) {
//    @Transactional
//    fun save(form: GenreForm) {
//        val genre = form.toUppercase()
//        Genre.valueOf(genre)
//    }
//
//    @Transactional
//    fun delete(id: Long) {
//    }
}